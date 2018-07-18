package com.my.mycomponent.user.bean;

import java.io.Serializable;

/**
 * @author WangJY
 * create at 2018/7/14
 */
public class UserBean implements Serializable{
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
