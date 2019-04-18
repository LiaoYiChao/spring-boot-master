package top.liaoyichao.demo.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/18 16:24
 * @Description: Master DataSource Configuration
 */
@Configuration
@MapperScan(basePackages = "top.liaoyichao.demo.mapper.master",sqlSessionFactoryRef = "masterDataSourceFactory")
public class MasterDataSourceConfig {

    /**
     * 数据源配置：
     *
     * 使用注解@ConfigurationProperties 指定内容并存入，@Primary 表示主数据库
     * @return DataSource
     */
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    @Primary
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 会话工厂：
     *
     * 注解：@Qualifier 表示使用那一个注入(@Bean中设置的名称就类似xml中bean中的name)
     * @param masterDataSource
     * @return SqlSessionFactory
     * @throws Exception
     */
    @Bean(name = "masterDataSourceFactory")
    @Primary
    public SqlSessionFactory masterSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(masterDataSource);
        return bean.getObject();
    }

    /**
     * 事务管理：
     *
     * @param masterDataSource
     * @return DataSourceTransactionManager
     */
    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager(@Qualifier("masterDataSource") DataSource masterDataSource){
        return new DataSourceTransactionManager(masterDataSource);
    }


    /**
     *
     * @param masterSessionFactory
     * @return
     */
    @Bean(name="masterSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("masterDataSourceFactory") SqlSessionFactory masterSessionFactory) {
        return new SqlSessionTemplate(masterSessionFactory);
    }

}
