package com.example.mycard.view;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycard.R;
import com.example.mycard.bean.User;
import com.example.mycard.presenter.UserPresenter;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,ILoginActivity{

    private  UserPresenter userPresenter;
    private EditText username;
    private EditText userpassword;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
         /*初始化控件*/
        initview();
        userPresenter = new UserPresenter(this);
    }

    private void initview(){
        username = (EditText)findViewById(R.id.editName);
        userpassword = (EditText)findViewById(R.id.editPassword);
        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                userPresenter.login();
                break;
            default:
                break;
        }
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getUserpassword() {
        return userpassword.getText().toString();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showSuccessMsg(User user) {
        Toast.makeText(LoginActivity.this,"User：" + getUsername() + " Login seccess !",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedMsg(String s) {
        Toast.makeText(LoginActivity.this,s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearEditText() {
        username.setText("");
        userpassword.setText("");
    }
}
