package top.liaoyichao.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Liao
 * exclude = {
 *         DataSourceAutoConfiguration.class}
 *      作用：禁用 DataSourceAutoConfiguration，SpringBoot会自动读取applicaiton.yml中，
 *      spring.datasource.* 属性并自动配置单数据源.
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class})
public class ListDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListDatasourceApplication.class, args);
    }

}
