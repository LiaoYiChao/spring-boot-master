package top.liaoyichao.core.social.qq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import top.liaoyichao.core.properties.SecurityProperties;
import top.liaoyichao.core.social.qq.factory.QQConnectionFactory;
import top.liaoyichao.core.social.qq.properties.QQProperties;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/24 08:43
 * @Description:
 *
 * --@ConditionalOnProperty 标识只有配置了该Properties 该类才起作用
 *  即配置了 my.security.social.qq.app-id = xxx 时起作用
 */
@Configuration
@ConditionalOnProperty(prefix = "my.security.social.qq",name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {

        QQProperties qqConfig = securityProperties.getSocial().getQq();

        return new QQConnectionFactory(qqConfig.getProviderId(),qqConfig.getAppId(),qqConfig.getAppSecret());
    }

}
