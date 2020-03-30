package com.soft1851.spring.orm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author CRQ
 */
@Configuration
@ComponentScan("com.soft1851.spring.orm")
public class JdbcConfig {
    /**
     * 数据连接池配置
     * @return
     */
    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/db_class?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        druidDataSource.setInitialSize(1);

        return druidDataSource;
     }

    /**
     * //DruidDataSource和JdbcTemplate为依赖关系
     * @param druidDataSource
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
        return new JdbcTemplate(druidDataSource);
    }

//    @Bean
//    public ForumDAO forumDAO(JdbcTemplate jdbcTemplate){
//        return new ForumDAOImpl(jdbcTemplate);
//    }
}
