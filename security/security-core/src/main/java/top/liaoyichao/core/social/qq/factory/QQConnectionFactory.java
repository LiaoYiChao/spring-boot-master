package top.liaoyichao.core.social.qq.factory;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import top.liaoyichao.core.social.qq.api.QQ;
import top.liaoyichao.core.social.qq.provider.QQAdapter;
import top.liaoyichao.core.social.qq.provider.QQServiceProvider;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/24 08:09
 * @Description:
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    public QQConnectionFactory(String providerId, String appId, String appSecret) {

        /**
         * providerId: 服务商唯一标识
         * serviceProvider： 服务配置
         * apiAdapter: 发送那些服务
         */
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());

    }

}
