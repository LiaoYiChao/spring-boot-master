package top.liaoyichao.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.liaoyichao.bll.service.impl.BsUserServiceImpl;
import top.liaoyichao.common.entity.BsUser;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/11 15:19
 * @Description: Bs_User Controller
 */
@RestController
public class BsUserController {

    @Autowired
    BsUserServiceImpl bsUserService;

    @GetMapping("/user/find/{id}")
    public BsUser findById(@PathVariable Integer id){
        return bsUserService.selectByPrimaryKey(id);
    }
}
