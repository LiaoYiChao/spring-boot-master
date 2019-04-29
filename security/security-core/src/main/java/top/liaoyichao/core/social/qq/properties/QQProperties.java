package top.liaoyichao.core.social.qq.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/24 08:37
 * @Description: AppId and appSecret 配置类
 */
@Data
public class QQProperties extends SocialProperties {

    /**
     * 服务商标识
     */
    private String providerId = "qq";

    /**
     * 回调Url 默认为/auth
     */
    private String filterProcessesUrl = "/auth";

}
