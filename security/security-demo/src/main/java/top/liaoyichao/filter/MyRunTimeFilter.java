package top.liaoyichao.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/20 17:06
 * @Description: Filter 查看执行时间
 */
//@Component
public class MyRunTimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyRunTimeFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("MyFilter doFilter");

        long creatTime = System.currentTimeMillis();

        //放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("总耗时  = " + (System.currentTimeMillis() - creatTime));
    }

    @Override
    public void destroy() {
        System.out.println("MyRunTimeFilter destroy");
    }
}
