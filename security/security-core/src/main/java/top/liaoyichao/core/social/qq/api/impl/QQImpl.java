package top.liaoyichao.core.social.qq.api.impl;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;
import top.liaoyichao.core.social.qq.api.QQ;
import top.liaoyichao.core.social.qq.api.QQUserInfo;

import java.io.IOException;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/23 21:35
 * @Description:
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

    /**
     * 获取 openid url地址
     */
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    /**
     * 返回数据的 url
     */
    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private ObjectMapper objectMapper = new ObjectMapper();

    private String appId;

    private String openId;

    public QQImpl(String accessToken, String appId){

        /**
         * TokenStrategy.ACCESS_TOKEN_PARAMETER
         *  当使用该策略的时候，父类会将 accessToken 当做请求后的参数进行传递
         *      localhost:8080/xx?xx=xx   -- 即这种请求？好后面的参数传递
         */
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);

        /**
         * format 方法：替换 把accessToken 替换掉 常量中最后的 %s
         */
        String url = String.format(URL_GET_OPENID, accessToken);

        /**
         * 发送一个请求 url地址 和返回的参数类型
         */
        String result = getRestTemplate().getForObject(url, String.class);

        /**
         * 获取openid 并赋值
         */
        this.openId = StringUtils.substringBetween(result,"\"openid\":","\"}");

        System.out.println(result);
    }

    public QQUserInfo getUserInfo() {

        String url = String.format(URL_GET_USERINFO, appId, openId);

        String result = getRestTemplate().getForObject(url, String.class);

        System.out.println(result);

        QQUserInfo qqUserInfo = null;

        try {
            qqUserInfo = objectMapper.readValue(result,QQUserInfo.class);
            qqUserInfo.setOpenId(openId);
            return qqUserInfo;
        } catch (Exception e) {
            throw new RuntimeException("获取用户信息失败",e);
        }

    }
}
