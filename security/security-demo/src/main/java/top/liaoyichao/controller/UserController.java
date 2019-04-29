package top.liaoyichao.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.liaoyichao.entity.User;
import top.liaoyichao.error.MyUserException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/19 23:36
 * @Description: User Controller
 */
@RestController
public class UserController {

    @GetMapping("/user")
    @JsonView(User.UserSimpleInterface.class)
    public List<User> query(User user, @PageableDefault(page = 2,sort = "age ASC",size = 15) Pageable pageable){

        System.out.println(user);

        System.out.println(pageable.getPageSize());

        System.out.println(pageable.getPageNumber());

        System.out.println(pageable.getSort());

        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));

        List<User> list = new ArrayList<User>();
        list.add(new User());
        list.add(new User());
        list.add(new User());

        return list;
    }


    /**
     * 自定义User Error 测试
     *
     * 浏览器返回 id	1
     *          message	"User Error"
     *
     * @param id
     * @return
     */
    @GetMapping("/user/error/{id}")
    public User testMyUserException(@PathVariable Integer id){

        throw new MyUserException(id);

    }


    @GetMapping("/user/{id:\\d+}")
    @JsonView(User.UserComplexInterface.class)
    public User queryOne(@PathVariable Integer id){

        throw new MyUserException(id);

//        User user = new User();
//        user.setAge(id);
//        user.setUserName("张三");
//
//        System.out.println(user);
//
//        return user;

    }

    @PostMapping("/user")
    public User create(@Valid @RequestBody User user , BindingResult result){

        if(result.hasErrors()){
            result.getAllErrors().forEach(
                    (error -> System.out.println(error.getDefaultMessage())));
        }

        System.out.println("post zhong");

        System.out.println(user.getUserName());
        System.out.println(user.getAge());
        System.out.println(user.getPassword());

        return user;
    }

    @PostMapping("/hello")
    public User createTest(@RequestBody User user){

        System.out.println("User = " + user);

        return user;
    }

    @GetMapping("/hello")
    public User createGetTest(@RequestBody User user){

        System.out.println("User = " + user);

        return user;
    }
}
