package com.example.guoxiaowen.entity;
import cn.bmob.v3.BmobObject;

public class RecoverData extends BmobObject {

    public String TSH ;
    public String FT3;
    public String FT4;
    public String TGAb;
    public String TPOAb;


    public String getFT3() {
        return FT3;
    }

    public String getFT4() {
        return FT4;
    }

    public String getTGAb() {
        return TGAb;
    }

    public String getTPOAb() {
        return TPOAb;
    }

    public String getTSH() {
        return TSH;
    }

    public void setFT3(String FT3) {
        this.FT3 = FT3;
    }

    public void setFT4(String FT4) {
        this.FT4 = FT4;
    }

    public void setTGAb(String TGAb) {
        this.TGAb = TGAb;
    }

    public void setTPOAb(String TPOAb) {
        this.TPOAb = TPOAb;
    }

    public void setTSH(String TSH) {
        this.TSH = TSH;
    }
}

