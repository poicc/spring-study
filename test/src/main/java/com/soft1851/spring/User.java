package com.soft1851.spring;

/**
 * @author CRQ
 */
public class User {
    private String account;
    private String password;

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public User(String account,String password) {
        this.account = account;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password=" + password +
                '}';
    }

    public User() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
