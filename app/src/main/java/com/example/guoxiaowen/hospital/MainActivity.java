package com.example.guoxiaowen.hospital;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guoxiaowen.entity.MyUser;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class MainActivity extends AppCompatActivity implements LoginDailogFragment.LoginInputListener,View.OnClickListener{

    private View login;
    private View register;
    private EditText name;
    public EditText password;
    private LoginDailogFragment fragment;
    private String userName;
    private String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "a897ddacdddf17f6e62744a92c294239");

        login = findViewById(R.id.main_login);
        register = findViewById(R.id.main_register);
        name = (EditText) findViewById(R.id.main_name);
        password = (EditText) findViewById(R.id.main_password);
        final String Name = name.getText().toString().trim();
        final String Password = password.getText().toString().trim();     //用以判断是否为空
        name.setFocusable(false);
        name.setOnClickListener(this);
        password.setFocusable(false);
        password.setOnClickListener(this);

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new LoginDailogFragment();
                fragment.show(getSupportFragmentManager(), "login");
            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new LoginDailogFragment();
                fragment.show(getSupportFragmentManager(), "login");
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = name.getText().toString().trim();
                String Password = password.getText().toString().trim();

                //2.判断是否为空
                if (!TextUtils.isEmpty(Name) && !TextUtils.isEmpty(Password)) {
                    //登录
                    final MyUser user = new MyUser();
                    user.setUsername(Name);
                    user.setPassword(Password);
                    user.login(new SaveListener<MyUser>() {
                        @Override
                        public void done(MyUser myUser, BmobException e) {
                            //判断结果
                            if (e == null) {
                                //判断邮箱是否验证
                                if (user.getEmailVerified()) {
                                    //跳转
                                    startActivity(new Intent(MainActivity.this, IndexActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(MainActivity.this, "请前往邮箱验证", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "登录失败：" + e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }

        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisteredActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onLoginInputComplete(String userName, String userPassword) {
        name.setText(userName);
        password.setText(userPassword);
    }
}

