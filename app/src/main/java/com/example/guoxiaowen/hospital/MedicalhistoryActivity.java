package com.example.guoxiaowen.hospital;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.guoxiaowen.entity.Medicalrecord;
import com.example.guoxiaowen.entity.MyUser;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MedicalhistoryActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText Name;
    private RadioGroup Sex;
    private EditText Hospital;
    private EditText Age;
    private EditText Marry;
    private EditText Career;
    private EditText Notion;
    private EditText Address;
    private EditText Hospital_date;
    private Button cancel;
    private Button ack;

    private boolean isGender = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploading1);
        initView();

    }

    private void initView() {

        Name = findViewById(R.id.name);
        Sex = findViewById(R.id.mRadioGroup);
        Hospital = findViewById(R.id.hospital);
        Age = findViewById(R.id.age);
        Marry = findViewById(R.id.marry);
        Career = findViewById(R.id.career);
        Notion = findViewById(R.id.notion);
        Address = findViewById(R.id.address);
        Hospital_date = findViewById(R.id.hospital_date);
        cancel = findViewById(R.id.cancel);
        ack = findViewById(R.id.ack);
        cancel.setOnClickListener(this);
        ack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.cancel:
                startActivity(new Intent(this,IndexActivity.class));
                break;
            case R.id.ack:
                String name = Name.getText().toString().trim();
                String hospital = Hospital.getText().toString().trim();
                String age = Age.getText().toString().trim();
                String marry = Marry.getText().toString().trim();
                String career = Career.getText().toString().trim();
                String notion = Notion.getText().toString().trim();
                String address = Address.getText().toString().trim();
                String hospital_date = Hospital_date.getText().toString().trim();

                Sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (checkedId == R.id.rb_boy) {
                            isGender = true;
                        } else if (checkedId == R.id.rb_girl) {
                            isGender = false;
                        }
                    }
                });

                Medicalrecord medicalrecord = new Medicalrecord();

                MyUser user = BmobUser.getCurrentUser(MyUser.class);

                medicalrecord.setAddress(address);
                medicalrecord.setAge(age);
                medicalrecord.setCareer(career);
                medicalrecord.setHospital(hospital);
                medicalrecord.setInhospital(hospital_date);
                medicalrecord.setName(name);
                medicalrecord.setMarriedage(marry);
                medicalrecord.setNationality(notion);
                medicalrecord.setSex(isGender);

                medicalrecord.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId, BmobException e) {
                        if (e == null) {
                            toast("添加数据成功，返回objectId为：" + objectId);
                        } else {
                            toast("创建数据失败：" + e.getMessage());
                        }
                    }

                    private void toast(String s) {
                        Toast.makeText(MedicalhistoryActivity.this,s,Toast.LENGTH_SHORT).show();
                    }
                });

//                startActivity(new Intent(this,IndexActivity.class));
                break;
        }
    }
}
