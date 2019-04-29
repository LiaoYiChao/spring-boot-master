package top.liaoyichao.web;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import top.liaoyichao.interceptor.MyRunTimeInterceptor;
import top.liaoyichao.filter.MyRunTimeFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/20 17:13
 * @Description: 配置 MyRunTimeFilter
 *      在第三方拦截器不支持 @Component 的时候 需要自行注册该拦截器 使用如下方法进行注册
 *          和Web.xml 中进行是一样的
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    MyRunTimeInterceptor interceptor;

    /**
     * 重写 WebMvcConfigurerAdapter 中的addInterceptors ，添加自定义的拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }


    /**
     * 注册 Filter 进入组件
     * @return
     */
    @Bean
    public FilterRegistrationBean timeFilter(){

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        MyRunTimeFilter filter = new MyRunTimeFilter();
        registrationBean.setFilter(filter);

        //代表拦截所有请求 可以定制拦截某些请求
        List<String> urlList = new ArrayList<>();
        urlList.add("/*");


        registrationBean.setUrlPatterns(urlList);

        return registrationBean;
    }

}
