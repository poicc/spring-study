package com.soft1851.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PhoneTest {
    @Autowired
    private Phone phone;

    @Autowired
    private Phone phone1;
    @Test
    public void print() {
        System.out.println(phone);
        System.out.println(phone1);
    }
}