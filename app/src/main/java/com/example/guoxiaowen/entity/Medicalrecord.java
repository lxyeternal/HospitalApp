package com.example.guoxiaowen.entity;


import cn.bmob.v3.BmobObject;

public class Medicalrecord extends BmobObject {

    public String name;
    public Boolean sex;
    public String hospital;
    public String age;
    public String marriedage;
    public String career;
    public String Nationality;
    public String address;
    public String inhospital;

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    public String getCareer() {
        return career;
    }

    public String getHospital() {
        return hospital;
    }

    public String getInhospital() {
        return inhospital;
    }

    public String getMarriedage() {
        return marriedage;
    }

    public String getName() {
        return name;
    }

    public Boolean getSex()
    {
        return sex;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public void setInhospital(String inhospital) {
        this.inhospital = inhospital;
    }

    public void setMarriedage(String marriedage) {
        this.marriedage = marriedage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

}
