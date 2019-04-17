package top.liaoyichao.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.liaoyichao.demo.entity.User;
import top.liaoyichao.demo.service.UserService;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/12 22:48
 * @Description: User Controller
 */
@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/user/find/{id}")
    public User findById(@PathVariable Integer id){
        System.out.println(id);
        return service.findOneById(id);
    }

}
