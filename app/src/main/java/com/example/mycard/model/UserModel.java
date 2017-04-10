package com.example.mycard.model;

import com.example.mycard.bean.User;

/**
 * Created by lijianfu on 2017/4/1.
 * 用户实现类
 */
public class UserModel implements IUserModel{

    @Override
    public void login(final String username, final String userpassword, final OnLoginListener onLoginListener) {
        /**
         * @author LJF
         * time:2017/4/1
         * 模拟子线程操作，执行耗时操作
         */
        new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    Thread.sleep(2000);
                    if (username.equals("shaniuer") && userpassword.equals("1204")){
                        onLoginListener.loginSuccess(new User(username,userpassword));
                    }else{
                        onLoginListener.loginFailed("请重新输入");
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
