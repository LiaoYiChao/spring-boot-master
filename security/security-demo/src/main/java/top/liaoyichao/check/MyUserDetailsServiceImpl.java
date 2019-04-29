package top.liaoyichao.check;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;


/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/22 20:51
 * @Description: Spring Security and Social 校验
 */
@Slf4j
@Component
public class MyUserDetailsServiceImpl implements UserDetailsService , SocialUserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * 配置 UserDetailsService 校验 即security 端校验
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        log.info("表单登陆的用户名",userName);

        return buildUser(userName);

    }


    /**
     * 配置 SocialUserDetailsService 校验 即社交登陆校验
     * @param userId
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {

        log.info("QQ登陆的用户名",userId);

        return buildUser(userId);
    }


    private SocialUserDetails buildUser(String userId) {
        String password = passwordEncoder.encode("123456");

        log.info("登陆的数据库密码",password);

        /**
         * userName --- 账号(从外部传入到这里的账号)
         * password --- 密码(该密码下方为死值，正常需要从数据库中查询)
         * true --- 认证是否过期
         * true --- 账号是否锁定(通常判断账号是否冻结)
         * true --- 密码是否过期
         * true --- 账号是否可用(通常判断账号是否删除)
         */
        return new SocialUser(userId,password,
                true,true,true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin")
        );
    }
}
