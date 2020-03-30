package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Phone;
import com.soft1851.spring.ioc.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CRQ
 */
@Configuration
@ComponentScan("com.soft1851.spring.ioc")
public class StudentConfig {
    @Bean
    public Student student(){
        Student student = new Student();
        student.setId(1);
        student.setName("poi");
        return student;
    }
    @Bean
    public Student student1(){
        Student student = new Student();
        student.setId(2);
        student.setName("oupai");
        return student;
    }

    @Bean
    public List<Phone> phone(Student student,Student student1){
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("华为",2000.0,student));
        phones.add(new Phone("vivo",2222.22,student1));
        return phones;
    }


}
