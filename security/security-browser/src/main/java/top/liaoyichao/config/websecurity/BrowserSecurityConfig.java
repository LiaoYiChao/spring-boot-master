package top.liaoyichao.config.websecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;
import sun.security.util.SecurityConstants;
import top.liaoyichao.core.properties.SecurityProperties;

import javax.sql.DataSource;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/22 20:38
 * @Description: Security Config
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SpringSocialConfigurer MySocialSecurityConfig;
    @Autowired
    private UserDetailsService userDetailsService;
    /**
     * 这里返回一个由 Spring Security 进行的密码加密和解密
     * 即便是相同的密码，Spring Security 也会生成一个新的加密密码.
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    public PersistentTokenRepository persistentTokenRepository() {

        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         *    http.addFilterBefore(Filter filter, Class<? extends Filter> beforeFilter)
         *    filter ---自身定义的filter
         *    Class<? extends Filter> beforeFilter ---在SpringSecurity 自身的 Filter 前加入
         *    比如 http.addFilterBefore(Filter filter, UsernamePasswordAuthenticationFilter)
         *
         *
         */

        //使用 表单 形式进行登陆
        http
                .formLogin()
                    .loginPage("/my/require")
                    .loginProcessingUrl("/my/from")
                .and()
                    .authorizeRequests()
                    .antMatchers("/my/require",
                        securityProperties.getBrowser().getSignUpUrl(),
                        securityProperties.getBrowser().getLoginPage()).permitAll()
                    .anyRequest()   //表示所有请求都拦截
                    .authenticated() //表示需要进行验证
                .and()
                    .csrf().disable() //关闭跨站请求安全拦截
                .rememberMe()
                    .tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(securityProperties.getBrowser().getTokenTime())
                    .userDetailsService(userDetailsService);

        http.apply(MySocialSecurityConfig);
        //使用 basic 形式进行登陆
//        http.httpBasic()
//                .and()
//                .authorizeRequests()
//                .anyRequest()   //表示所有请求都拦截
//                .authenticated();   //表示需要进行验证
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("").roles();

        auth.jdbcAuthentication()
                .withUser("").roles();
    }
}
