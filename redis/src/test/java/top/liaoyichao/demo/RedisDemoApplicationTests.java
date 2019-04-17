package top.liaoyichao.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import top.liaoyichao.demo.entity.User;
import top.liaoyichao.demo.mapper.UserMapper;
import top.liaoyichao.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {

        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);

    }

    @Test
    public void test1(){

        stringRedisTemplate.opsForValue().append("msg","hello");

    }

    @Test
    public void test2(){
        User user = userMapper.selectByPrimaryKey(1);
        redisTemplate.opsForValue().set("user-01",user);
    }

}
