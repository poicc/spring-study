package com.soft1851.spring.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author CRQ
 */
@Configuration
@ComponentScan("com.soft1851.spring.web")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class SpringDataSourceConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;
    /**
     * 数据连接池配置
     * @return
     */
    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        //配置初始大小，最小最大连接数
        druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(20);
        //配置间隔多久才进行一次检测，检测需要关闭的连接，单位为毫秒
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        //配置一个连接在池中最小生存的时间
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        //禁止自动提交，实现事务管理
        druidDataSource.setDefaultAutoCommit(true);
        //设置连接池启用预处理事务集
        druidDataSource.setPoolPreparedStatements(true);
        return druidDataSource;

    }

    /**
     * jdbcTemplate配置模板
     * @param druidDataSource
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
        return new JdbcTemplate(druidDataSource);
    }
//    /**
//     * DruidDataSource和JdbcTemplate为依赖关系
//     * @return
//     */
//    @Bean
//    public JdbcTemplate jdbcTemplate(){
//        return new JdbcTemplate(druidDataSource());
//    }

    /**
     * 装配事务管理器
     * @param druidDataSource
     * @return DataSourceTransactionManager
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource druidDataSource){
        return  new DataSourceTransactionManager(druidDataSource);
    }
}
