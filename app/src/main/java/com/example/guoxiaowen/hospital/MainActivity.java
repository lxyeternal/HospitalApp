package com.example.guoxiaowen.hospital;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoginDailogFragment.LoginInputListener{

    private Button login;
    private TextView name;
    private TextView password;
    private LoginDailogFragment fragment;
    private String userName;
    private String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login= findViewById(R.id.main_login);
        name= findViewById(R.id.main_name);
        password= findViewById(R.id.main_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment= new LoginDailogFragment();
                fragment.show(getSupportFragmentManager(), "login");
            }
        });
    }

    @Override
    public void onLoginInputComplete(String userName, String userPassword) {
        name.setText(userName);
        password.setText(userPassword);
    }

}
