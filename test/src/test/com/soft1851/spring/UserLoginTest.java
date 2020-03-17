package com.soft1851.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/userApplicationContext.xml"})
public class UserLoginTest {
    @Autowired
    private UserLogin userLogin;
    @Autowired
    private User user;
    @Test
    public void userLogin() {
        System.out.println("用户名:"+user.getAccount());
        System.out.println("密码:"+user.getPassword());
        if(userLogin.userLogin(user) ==true){
            System.out.println("登录成功！！");
        }else{
            System.out.println("登录失败");
        }

    }
}