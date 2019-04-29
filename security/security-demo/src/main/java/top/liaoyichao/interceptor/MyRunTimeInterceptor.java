package top.liaoyichao.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/20 17:25
 * @Description: Spring 定义的拦截器 HandlerInterceptor
 *      主要多了 参数Object o ---通过该参数 可以得到当前那个方法进行的处理，那个类进行的处理
 */
@Component
public class MyRunTimeInterceptor implements HandlerInterceptor {

    /**
     * 方法执行之前 顺序 1
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

//        HandlerMethod handler = (HandlerMethod) o;
//
//        System.out.println(handler.getBean().getClass().getName());
//        System.out.println(handler.getMethod().getName());
//
//
//        System.out.println("My RunTime Interceptor PreHandle");
//
//        httpServletRequest.setAttribute("time",System.currentTimeMillis());

        return true;
    }

    /**
     * 方法执行之后 顺序 2
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

//        long time = (long) httpServletRequest.getAttribute("time");
//        System.out.println("post-总耗时"+ (System.currentTimeMillis() - time));
//
//        System.out.println("My RunTime Interceptor PreHandle PostHandle");

    }

    /**
     * 方法执行之后 顺序 3
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

//        long time = (long) httpServletRequest.getAttribute("time");
//        System.out.println("after-总耗时"+ (System.currentTimeMillis() - time));
//
//        System.out.println("My RunTime Interceptor PreHandle AfterHandle");

    }
}
