package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.config.SortConfig;
import com.soft1851.spring.ioc.entity.Sort;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author CRQ
 */
public class SortTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SortConfig.class);
        ctx.scan("com.soft.1851.spring.ioc.config");
        Sort sort = (Sort) ctx.getBean("sort");
        System.out.println(sort);
    }
}
