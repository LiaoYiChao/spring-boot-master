package top.liaoyichao.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import top.liaoyichao.core.properties.browser.BrowserProperties;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/23 14:52
 * @Description: Application.yml 中自定义的配置 my.security.xx
 */
@ConfigurationProperties(prefix = "my.security")
@Data
public class SecurityProperties {

    /**
     * 需要注意事项 这里的变量名也是一层
     * 如在 application.yml 中配置了
     * my.security.browser.xxx
     * 这里的browser 为配置中的 browser
     */
    private BrowserProperties browser = new BrowserProperties();

    private SocialProperties social = new SocialProperties();
}
