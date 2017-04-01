package com.example.mycard.presenter;

import android.os.Handler;

import com.example.mycard.bean.User;
import com.example.mycard.model.IUserModel;
import com.example.mycard.model.UserModel;
import com.example.mycard.view.LoginActivity;

/**
 * Created by lijianfu on 2017/4/1.
 */
public class UserPresenter{

    private LoginActivity loginActivity;
    private UserModel userModel;
    private Handler mHandler;

    public UserPresenter(LoginActivity loginActivity){
        this.loginActivity = loginActivity;
        userModel = new UserModel();
        mHandler = new Handler();
    }

    public void login(){
        loginActivity.showLoading();
        userModel.login(loginActivity.getUsername(),loginActivity.getUserpassword(),new IUserModel.OnLoginListener(){
            @Override
            public void loginSuccess(final User user) {
                /*模拟成功登陆*/
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginActivity.showSuccessMsg(user);
                        loginActivity.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed(final String s) {
                /*模拟登陆失败*/
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginActivity.showFailedMsg(s);
                        loginActivity.hideLoading();
                    }
                });
            }
        });
    }
}
