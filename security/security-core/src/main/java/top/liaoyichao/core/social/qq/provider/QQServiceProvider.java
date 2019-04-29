package top.liaoyichao.core.social.qq.provider;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import top.liaoyichao.core.social.qq.api.QQ;
import top.liaoyichao.core.social.qq.api.impl.QQImpl;
import top.liaoyichao.core.social.qq.template.QQOAuth2Template;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/23 22:29
 * @Description:
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;

    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    public QQServiceProvider(String appId, String appSecret) {
        super(new QQOAuth2Template(appId,appSecret,URL_AUTHORIZE,URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    @Override
    public QQ getApi(String accessToken) {

        return new QQImpl(accessToken,appId);

    }

}
