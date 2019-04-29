package top.liaoyichao.core.social.qq.provider;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import top.liaoyichao.core.social.qq.api.QQ;
import top.liaoyichao.core.social.qq.api.QQUserInfo;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/23 22:42
 * @Description:
 */
public class QQAdapter implements ApiAdapter<QQ> {

    /**
     * 测试当前 QQ服务 是否可用
     * @param qq
     * @return
     */
    public boolean test(QQ qq) {
        return true;
    }


    public void setConnectionValues(QQ qq, ConnectionValues connectionValues) {

        QQUserInfo userInfo = qq.getUserInfo();

        //QQ 名称
        connectionValues.setDisplayName(userInfo.getNickname());

        //QQ 头像
        connectionValues.setImageUrl(userInfo.getFigureurl_qq_1());

        //个人地址 但qq是没有的 类似个人发的动态时间线网站
        connectionValues.setProfileUrl(null);

        //用户Id 在服务商的唯一Id
        connectionValues.setProviderUserId(userInfo.getOpenId());
    }

    /**
     * 用于解绑使用
     * @param qq
     * @return
     */
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    /**
     * 该方法主要用于 发送消息 但QQ中没有发送消息，配置其他 如微博时需要使用
     * @param qq
     * @param message
     */
    public void updateStatus(QQ qq, String message) {

    }
}
