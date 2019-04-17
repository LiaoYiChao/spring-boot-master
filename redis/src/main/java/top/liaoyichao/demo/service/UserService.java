package top.liaoyichao.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;
import top.liaoyichao.demo.entity.User;
import top.liaoyichao.demo.mapper.UserMapper;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/12 22:39
 * @Description: User Service
 */
@Service
public class UserService {

    @Autowired
    UserMapper mapper;


//    不使用注解方式
//    @Qualifier("userCacheManager")
//    @Autowired
//    RedisCacheManager userCacheManager;

//    public User findOneById(Integer id){
//        User user1 = mapper.selectByPrimaryKey(id);
//        Cache user = userCacheManager.getCache("user");
//        user.put("user",user1);
//        return user1;
//    }

    /**
     * 使用注解方式
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "UserFindOneById",cacheManager = "userCacheManager")
    public User findOneById(Integer id){
        return mapper.selectByPrimaryKey(id);
    }


}