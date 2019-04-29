package top.liaoyichao.demo.controller;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.liaoyichao.demo.common.ReturnCode;
import top.liaoyichao.demo.entity.User;
import top.liaoyichao.demo.service.UserService;

import java.util.List;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/29 16:45
 * @Description: User Controller
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> pageUser(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "3")int pageSize){

        logger.info("---UserController---pageUser---");

        PageHelper.startPage(pageNum,pageSize);
        return userService.selectUserPage();

    }

    @PostMapping
    public Boolean insertUser(User user){

        logger.info("---UserController---insertUser---");

        if(user != null)
        {
            return userService.insertUser(user);
        }

        return false;

    }

    public Boolean updateUser(User user){

        logger.info("---UserController---updateUser---");

        if(user != null)
        {
            userService.updateUser(user);
        }

        return false;
    }

    /**
     * 正则URL : 后面跟正则表达式 这里表示只能输入整数 且第一个非0
     * @param id
     * @return
     */
    @GetMapping("/delete/{id:^[1-9]\\d*|0$")
    public Boolean deleteUser(@PathVariable Integer id){

        logger.info("---UserController---deleteUser---");

        if(id != null)
        {
            return userService.deleteUser(id,2);
        }

        return false;

    }
}
