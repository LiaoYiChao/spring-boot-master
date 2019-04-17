package top.liaoyichao.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import top.liaoyichao.demo.entity.User;

import java.net.UnknownHostException;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/12 23:47
 * @Description: Redis Config
 */
@Configuration
public class RedisConfig {

    /**
     * @Primary 该注解代表其是一个默认的使用方法 如果不值当 则使用该默认方法
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Primary
    @Bean
    @ConditionalOnMissingBean(
            name = {"redisTemplate"}
    )
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /**
     * 当有多个需要进行反序列化 以JSON格式存入Redis的时候 相同的步骤 使用下方代码 只是把User该为另外的即可
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Bean
    public RedisTemplate<Object, User> userRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object,User> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<User> jack = new Jackson2JsonRedisSerializer<>(User.class);
        template.setDefaultSerializer(jack);
        return template;
    }


    /**
     * 但是在使用的是需要在 被使用的地方加上 cacheManager = "userCacheManager"
     *  如果下为相同bena操作类 使用
     *      CacheConfig(cacheManager = "userCacheManager")
     *  如果为某个方法
     *      Cacheable(cacheManager = "userCacheManager")
     *          名称为下方法名称
     * @param userRedisTemplate
     * @return
     */
    @Bean
    public RedisCacheManager userCacheManager(RedisTemplate<Object, User> userRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(userRedisTemplate);
        cacheManager.setUsePrefix(true);

        return cacheManager;
    }
}
