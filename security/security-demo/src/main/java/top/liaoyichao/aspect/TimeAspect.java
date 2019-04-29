package top.liaoyichao.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import top.liaoyichao.error.MyUserException;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/20 17:49
 * @Description: My Time Aspect
 */
//@Aspect
//@Component
public class TimeAspect {

    @Around("execution(* top.liaoyichao.controller.UserController.*(..))")
    public Object handlerUserControllerAspect(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("handlerUserControllerAspect start");

        Object[] args = pjp.getArgs();
        for (Object arg:args
             ) {
            System.out.println("arg is :" + arg);
        }

        //含义：类似放行
        Object proceed = pjp.proceed();

        return proceed;
    }

    @AfterThrowing(pointcut = "execution(* top.liaoyichao.controller.UserController.*(..))",throwing = "ex")
    public void handlerUserControllerException(MyUserException ex){

        System.out.println("HandlerUserControllerException -------------");

        System.out.println("异常 = " + ex);
    }
}
