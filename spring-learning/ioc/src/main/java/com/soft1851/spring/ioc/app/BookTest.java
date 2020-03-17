package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.config.AppConfig;
import com.soft1851.spring.ioc.entity.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author CRQ
 */
public class BookTest {
    public static void main(String[] args) {
        //生成基于注解的应用上下文对象
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //手动扫包
        ctx.scan("com.soft1851.spring.ioc.config");
        Book book = (Book) ctx.getBean("book");
        book.setName("人间失格");
        book.setPrice(59.9);
        System.out.println(book);
    }
}
