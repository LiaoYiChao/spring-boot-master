package top.liaoyichao.core.properties.browser;

import lombok.Data;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/23 14:53
 * @Description: Browser 的Application 配置
 */
@Data
public class BrowserProperties {

    /**
     * 设置登陆页
     */
    private String loginPage = "/my-login.html";

    /**
     * 设置注册页
     */
    private String signUpUrl = "/my-signUp.html";

    private Integer tokenTime = 10000;
}
