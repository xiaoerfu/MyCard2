package com.example.mycard.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycard.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText registerName;
    private EditText registerPass;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    /*初始化控件*/
    private void initView(){
        registerName = (EditText)findViewById(R.id.editName);
        registerPass = (EditText)findViewById(R.id.editPassword);
        register = (Button)findViewById(R.id.register);

        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                Toast.makeText(this,"注册成功，请重新登陆",Toast.LENGTH_SHORT).show();
                Intent login = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(login);
                break;
            default:
                break;
        }
    }
}
