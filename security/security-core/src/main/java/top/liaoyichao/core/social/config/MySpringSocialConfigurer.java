package top.liaoyichao.core.social.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;
import top.liaoyichao.core.properties.SecurityProperties;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/24 16:36
 * @Description: 覆盖父类中的 SpringSocialConfigurer
 *
 */
public class MySpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public MySpringSocialConfigurer(String filterProcessesUrl){
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter socialAuthenticationFilter = (SocialAuthenticationFilter) postProcess(object);

        //把默认的 /auth 变为可定义的
        socialAuthenticationFilter.setFilterProcessesUrl(filterProcessesUrl);
        return (T) socialAuthenticationFilter;
    }
}
