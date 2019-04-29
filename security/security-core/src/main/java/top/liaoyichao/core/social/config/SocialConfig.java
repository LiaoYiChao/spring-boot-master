package top.liaoyichao.core.social.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.security.SpringSocialConfigurer;
import top.liaoyichao.core.properties.SecurityProperties;

import javax.sql.DataSource;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/24 08:17
 * @Description: Social 配置类
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {


        /**
         * create table UserConnection (userId varchar(255) not null,
         * 	providerId varchar(255) not null,
         * 	providerUserId varchar(255),
         * 	rank int not null,
         * 	displayName varchar(255),
         * 	profileUrl varchar(512),
         * 	imageUrl varchar(512),
         * 	accessToken varchar(512) not null,
         * 	secret varchar(512),
         * 	refreshToken varchar(512),
         * 	expireTime bigint,
         * 	primary key (userId, providerId, providerUserId));
         * create unique index UserConnectionRank on UserConnection(userId, providerId, rank);
         *
         * 该表是下JdbcUsersConnectionRepository 需要的 且唯一的
         * 可以设置前缀名称 在下方进行配置
         */

        /**
         * 参数1：数据源
         * 参数2：connectionFactoryLocator 查找所有的connectionFactoryLocator 并决定使用那个connectionFactoryLocator
         *      因为会有多个connectionFactoryLocator 微博一个 QQ一个 等等
         * 参数3：加密
         *      Encryptors.noOpText() --表示不做任何操作
         *
         *      加密主要为 从服务商拿到数据后 存入数据库最佳 加密处理
         */
        JdbcUsersConnectionRepository jdbcUsersConnectionRepository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());

        //当设置的数据库有前缀名称的时候 在这里设置前缀名称
        //jdbcUsersConnectionRepository.setTablePrefix("");

        return jdbcUsersConnectionRepository;
    }


    @Bean
    public SpringSocialConfigurer MySocialSecurityConfig() {

        /**
         * 可配置回调url 默认/auth
         */
        MySpringSocialConfigurer mySpringSocialConfigurer = new MySpringSocialConfigurer(securityProperties.getSocial().getQq().getFilterProcessesUrl());

        //告知 filter 注册界面 为那个
        mySpringSocialConfigurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());

        return mySpringSocialConfigurer;
    }


}
