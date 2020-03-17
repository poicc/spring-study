package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.entity.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CRQ
 */
public class HelloTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Hello hello = (Hello) ac.getBean("hello");
        hello.sayHello();
    }
}
