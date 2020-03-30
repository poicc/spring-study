package com.soft1851.spring.ioc.entity;

import com.soft1851.spring.ioc.config.StudentConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {StudentConfig.class})
public class StudentTest {
@Autowired
    private List<Phone> phones;

@Test
    public void printPhone(){
    phones.forEach(System.out::println);
}
}