package com.example.guoxiaowen.hospital;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guoxiaowen.entity.Constant;
import com.example.guoxiaowen.entity.RecoverData;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class Uploaddata extends Constant implements View.OnClickListener{

    private EditText TSH;
    private EditText FT3;
    private EditText FT4;
    private EditText TGAb;
    private EditText TPOAb;
    private Button ack;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploaddate);
        Bmob.initialize(this,BmobID);
        initView();

    }

    private void initView() {

        TSH = findViewById(R.id.TSH);
        FT3 = findViewById(R.id.FT3);
        FT4 = findViewById(R.id.FT4);
        TGAb = findViewById(R.id.TGAb);
        TPOAb = findViewById(R.id.TPOAb);
        ack = findViewById(R.id.ack);
        ack.setOnClickListener(this);
        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ack:
                String tsh = TSH.getText().toString().trim();
                String ft3 = FT3.getText().toString().trim();
                String ft4 = FT4.getText().toString().trim();
                String tgab = TGAb.getText().toString().trim();
                String tpoab = TPOAb.getText().toString().trim();

                RecoverData recoverData = new RecoverData();

                recoverData.setTSH(tsh);
                recoverData.setFT3(ft3);
                recoverData.setFT4(ft4);
                recoverData.setTGAb(tgab);
                recoverData.setTPOAb(tpoab);

                recoverData.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId, BmobException e) {
                        if(e == null)
                        {
                            toast("添加数据成功，返回objectId为：" + objectId);
                        }
                        else
                        {
                            toast("数据添加失败" + e.getMessage());
                        }
                    }

                    private void toast(String s) {
                        Toast.makeText(Uploaddata.this,s,Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.cancel:
                startActivity(new Intent(this,IndexActivity.class));
                break;

        }
    }
}
