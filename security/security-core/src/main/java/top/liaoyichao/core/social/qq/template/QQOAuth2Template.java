package top.liaoyichao.core.social.qq.template;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/24 17:08
 * @Description: 自定义某些 OAuth2Template
 */
@Log4j
public class QQOAuth2Template extends OAuth2Template {

    public QQOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
    }

    /**
     * access_token=FE04************************CCE2&expires_in=7776000&refresh_token=88E4************************BE14
     *
     * QQ Access Token 成功返回如上 但Spring Social 默认为getRestTemplate().postForObject(accessTokenUrl, parameters, Map.class, new Object[0]));
     *  一个Map类型 取其中的JSON数据 但成功返回数据为一个字符串 所以需要进行覆盖调整
     * @param accessTokenUrl
     * @param parameters
     * @return
     */
    @Override
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {

        String responseStr = getRestTemplate().postForObject(accessTokenUrl,parameters,String.class);

        log.info("返回的Access Token" + responseStr);

        String[] tokens = StringUtils.splitByWholeSeparatorPreserveAllTokens(responseStr, "&");

        String accessToken = StringUtils.substringAfterLast(tokens[0],"=");
        Long expiresIn = new Long(StringUtils.substringAfterLast(tokens[1],"="));
        String refreshToken = StringUtils.substringAfterLast(tokens[2],"=");

        return new AccessGrant(accessToken, null, refreshToken, expiresIn);
    }

    /**
     * 该Template 主要多实现一个 OAuth2Template中的 RestTemplate 处理不了 text-html请求的实现，因为QQ发送过来的为一个text-html
     * @return
     */
    @Override
    protected RestTemplate createRestTemplate() {

        RestTemplate restTemplate = new RestTemplate();

        /**
         * new StringHttpMessageConverter ---处理 text-html 使用
         */
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));

        return restTemplate;
    }
}
