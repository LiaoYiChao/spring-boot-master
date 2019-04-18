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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/18 16:24
 * @Description: Cluster DataSource Configuration
 */
@Configuration
@MapperScan(basePackages = "top.liaoyichao.demo.mapper.cluster",sqlSessionFactoryRef = "clusterDataSourceFactory")
public class ClusterDataSourceConfig {

    /**
     * 数据源配置：
     * @return DataSource
     */
    @Bean(name = "clusterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.cluster")
    public DataSource clusterDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 会话工厂：
     *
     * 注解：@Qualifier 表示使用那一个注入(@Bean中设置的名称就类似xml中bean中的name)
     * @param clusterDataSource
     * @return SqlSessionFactory
     * @throws Exception
     */
    @Bean(name = "clusterDataSourceFactory")
    public SqlSessionFactory clusterSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(clusterDataSource);
        return bean.getObject();
    }

    /**
     * 事务管理：
     *
     * @param clusterDataSource
     * @return DataSourceTransactionManager
     */
    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(@Qualifier("clusterDataSource") DataSource clusterDataSource){
        return new DataSourceTransactionManager(clusterDataSource);
    }


    /**
     *
     * @param clusterSessionFactory
     * @return
     */
    @Bean(name="clusterSqlSessionTemplate")
    public SqlSessionTemplate clusterSqlSessionTemplate(@Qualifier("clusterDataSourceFactory") SqlSessionFactory clusterSessionFactory) {
        return new SqlSessionTemplate(clusterSessionFactory);
    }

}
