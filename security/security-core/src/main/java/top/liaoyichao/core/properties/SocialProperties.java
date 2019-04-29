package top.liaoyichao.core.properties;

import lombok.Data;
import top.liaoyichao.core.social.qq.properties.QQProperties;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/24 08:40
 * @Description: Social 配置总类
 */
@Data
public class SocialProperties {

    private QQProperties qq = new QQProperties();

}
