package com.example.mycard.view;

import com.example.mycard.bean.User;

/**
 * Created by lijianfu on 2017/4/1.
 */
public interface ILoginActivity {

    //得到用户填写的信息
    String getUsername();
    String getUserpassword();

    //显示和隐藏登录ProgressBar
    void showLoading();
    void hideLoading();

    //登录成功或失败后，返回信息的方法
    void showSuccessMsg(User user);
    void showFailedMsg(String s);

    //清楚数据
    void clearEditText();
}
