package com.example.mycard.model;

import com.example.mycard.bean.User;

/**
 * Created by lijianfu on 2017/4/1.
 * 用户接口类
 */
public interface IUserModel {

    void login(String username, String userpassword, OnLoginListener onLoginListener);

    interface OnLoginListener {
        void loginSuccess(User user);

        void loginFailed(String s);
    }

}
