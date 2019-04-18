package top.liaoyichao.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.liaoyichao.demo.service.AsyncService;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/18 20:27
 * @Description: Async Controller
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/async")
    public String asyncTestController(){
        asyncService.asyncTest();
        return "Hello";
    }
}
