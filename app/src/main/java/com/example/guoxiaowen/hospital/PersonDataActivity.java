package com.example.guoxiaowen.hospital;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PersonDataActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        initView();

    }

    private void initView() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.information:
                startActivity(new Intent(this,Personoption.class));
                break;
            case R.id.passwordchange:
                startActivity(new Intent(this,ForgetPasswordActivity.class));
                break;
        }

    }
}
