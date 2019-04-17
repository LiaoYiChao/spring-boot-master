package top.liaoyichao.demo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.liaoyichao.demo.entity.User;
import top.liaoyichao.demo.mapper.UserMapper;
import top.liaoyichao.demo.service.impl.UserServiceImpl;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusDemoApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void insert() {

        User user = new User();
        user.setId(1L);
        user.setAge(12);
        user.setEmail("xxxx");
        user.setName("zhangsan");

        for (int i = 0; i < 5; i++) {
            user.setAge(12 + i);
            user.setEmail("xxxx" + i);
            user.setName("zhangsan" + i);
            userMapper.insert(user);
        }

    }

    @Test
    public void select(){

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }

    @Test
    public void delete(){

        for (int i = 5; i < 11; i++) {
            userMapper.deleteById(i);
        }

    }

    @Test
    public void update(){

        /**
         * QueryWrapper(查询条件) and UpdateWrapper(更新条件)
         * 具体请参考
         * 官方：
         * https://mp.baomidou.com/guide/wrapper.html#alleq
         * 博客：
         * https://blog.csdn.net/m0_37034294/article/details/82917234
         */
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        User user = new User();
        user.setAge(800);
        updateWrapper.eq("id",4);
        userMapper.update(user,updateWrapper);

    }
}
