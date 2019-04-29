package top.liaoyichao.core.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import top.liaoyichao.core.properties.SecurityProperties;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/23 14:56
 * @Description: 配置类
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
