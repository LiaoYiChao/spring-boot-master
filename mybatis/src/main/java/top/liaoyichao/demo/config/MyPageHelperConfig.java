package top.liaoyichao.demo.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/29 17:09
 * @Description: PageHelper Config
 */
@Configuration
public class MyPageHelperConfig {

    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();

        Properties p = new Properties();
        p.setProperty("offsetAsPageNum","true");
        p.setProperty("rowBoundsWithCount","true");
        p.setProperty("reasonable","true");

        pageHelper.setProperties(p);

        return pageHelper;
    }
}
