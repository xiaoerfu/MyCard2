package com.example.mycard.bean;

/**
 * Created by lijianfu on 2017/4/1.
 * 创建用户实体类
 */
public class User{

    private int id;
    private String username;
    private String userpassword;

    public User(String username, String userpassword) {
        this.username = username;
        this.userpassword = userpassword;
    }

    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    @Override
    public String toString() {
        return "User{" +"id=" + id +'\'' +
                "username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                '}';
    }
}
