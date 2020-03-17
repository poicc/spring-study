package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CRQ
 */
public class StudentText {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student)ac.getBean("student");
        Student student1 = (Student) ac.getBean("student1");
        Student student2 = (Student) ac.getBean("student2");
        System.out.println(student);
        System.out.println(student1);
        System.out.println(student2);
    }
}
