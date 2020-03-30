package com.soft1851.spring.ioc.test;



import com.soft1851.spring.ioc.entity.Forum;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


/**
 * @author CRQ
 */
public class JdbcTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcConfig.class);
        ctx.scan("com.soft1851.spring.ioc.config");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);
//        String  sql = "SELECT * FROM t_forum ";
//        List<Forum> forumList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Forum.class));
//        System.out.println(forumList);

        ForumDAO forumDAO = (ForumDAO) ctx.getBean("forumDAO");
        List<Forum> forums = forumDAO.selectAll();
        System.out.println(forums);
    }
}
