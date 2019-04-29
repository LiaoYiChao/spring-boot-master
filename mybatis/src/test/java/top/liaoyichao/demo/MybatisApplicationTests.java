package top.liaoyichao.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.liaoyichao.demo.entity.User;
import top.liaoyichao.demo.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {


        User user = new User();
        user.setName("王五").setAge(11).setEmail("13644423@qq.com").setId(6);

        userMapper.insertUser(user);

    }

    @Test
    public void deleteUser(){

        userMapper.deleteUser(1,1);

    }

}
