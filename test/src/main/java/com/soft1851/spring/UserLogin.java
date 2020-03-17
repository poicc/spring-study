package com.soft1851.spring;

/**
 * @author CRQ
 */
public class UserLogin {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public boolean userLogin(User user) {


        return  user.getAccount().equals("admin") && user.getPassword().equals("111");
    }

}

