package top.liaoyichao.demo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.liaoyichao.demo.common.ReturnCode;
import top.liaoyichao.demo.entity.User;
import top.liaoyichao.demo.mapper.UserMapper;

import java.util.List;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/29 16:25
 * @Description: User Service
 */
@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserMapper userMapper;

    public List<User> selectUserPage(){
        logger.info("selectUserPage执行");
        return userMapper.findAllUser();
    }

    public boolean insertUser(User user){
        logger.info("insertUser执行");
        return userMapper.insertUser(user);
    }

    public boolean updateUser(User user){
        logger.info("updateUser执行");
        return userMapper.updateUser(user);
    }

    public boolean deleteUser(Integer id, Integer del){
        return userMapper.deleteUser(id, del);
    }
}
