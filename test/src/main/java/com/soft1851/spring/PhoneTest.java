package com.soft1851.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CRQ
 */
public class PhoneTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Phone phone = (Phone) ac.getBean("phone");
        System.out.println(phone);
    }
}
