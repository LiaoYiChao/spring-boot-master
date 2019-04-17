package top.liaoyichao.demo.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/16 19:41
 * @Description: RabbitMQ Config
 */
@Configuration
public class MyRabbitMqConfig {

    /**
     * RabbitMQ 默认为JDK序列化把消息发送给消息队列，这里转换为JSON的方式序列化
     * @return MessageConverter
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
