package com.example.mycard.view;

import com.example.mycard.bean.User;

/**
 * Created by lijianfu on 2017/4/5.
 * 注册的接口
 */
public interface IRegisterActivity {

    //登录成功或失败后，返回信息的方法
    void RegisterSuccessMsg(User user);
    void RegisterFailedMsg(String s);

    //清楚数据
    void clearEditText();
}
