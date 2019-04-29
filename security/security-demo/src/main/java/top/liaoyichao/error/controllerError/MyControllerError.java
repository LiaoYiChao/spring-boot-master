package top.liaoyichao.error.controllerError;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import top.liaoyichao.error.MyUserException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/20 16:25
 * @Description: Controller Error
 *  -- @ControllerAdvice
 *      标记该注解 表示该类专门处理其他Controller 发生的错误
 *
 *  -- @ExceptionHandler(MyUserException.class)
 *       表示处理那种异常 需要传入一个异常类
 *
 *  -- @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
 *       表示出现该中错误后 的返回码 如这里为 500 错误
 */
@ControllerAdvice
public class MyControllerError {


    @ExceptionHandler(MyUserException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handMyUserException(MyUserException ue){

        Map<String,Object> map = new HashMap<>();
        map.put("id",ue.getId());
        map.put("message",ue.getMessage());

        return map;

    }

}
