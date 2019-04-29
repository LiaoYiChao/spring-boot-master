package top.liaoyichao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import top.liaoyichao.config.websecurity.SimpleResponseObject;
import top.liaoyichao.core.properties.SecurityProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/23 11:51
 * @Description: 配置用户权限认证跳转
 */
@RestController
@Slf4j
public class BrowserSecurityController {

    private static final String check = ".html";

    /**
     * Spring工具类 拿到请求的url
     */
    private RequestCache requestCache = new HttpSessionRequestCache();

    /**
     * 通过该类进行请求跳转
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    @RequestMapping("/my/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponseObject requireAuthentication(HttpServletResponse response, HttpServletRequest request) throws IOException {

        //拿到请求url
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if(savedRequest != null){
            String redirectUrl = savedRequest.getRedirectUrl();

            log.info("当前跳转请求为" + redirectUrl);

            if(StringUtils.endsWithIgnoreCase(redirectUrl,check)){
                //当引起的跳转请求为 .html 结尾时
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
            }
        }


        return new SimpleResponseObject("访问的服务需要身份认证");
    }
}
