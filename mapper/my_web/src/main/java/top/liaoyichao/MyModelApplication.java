package top.liaoyichao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/11 15:19
 * @Description: SpringBoot 启动类
 */
@SpringBootApplication
@MapperScan(basePackages = "top.liaoyichao.common.mapper")
public class MyModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyModelApplication.class, args);
    }

}
