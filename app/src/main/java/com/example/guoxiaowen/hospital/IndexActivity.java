package com.example.guoxiaowen.hospital;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.guoxiaowen.hospital.MyViewPager;
import java.util.ArrayList;
import java.util.List;

//主页面的文件

public class IndexActivity extends AppCompatActivity {


    //    private static final String TAG = "MainActivity";
//    private MyViewPager mLoopPager;
//    private LooperPagerAdapter mLooperPagerAdapter;
//
//    private static List<Integer> sPics = new ArrayList<>();
//    static {
//        sPics.add(R.mipmap.pic1);
//        sPics.add(R.mipmap.pic2);
//        sPics.add(R.mipmap.pic3);
//    }
//
//    private Handler mHandler;
//    private boolean mIsTouch = false;
//    private LinearLayout mPointContainer;
    private ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_index);

//        initView();
        imageButton1 = (ImageButton) findViewById(R.id.imagebtn1);
        imageButton1.setOnClickListener(new ImageButtonOnClick());
        imageButton2 = (ImageButton) findViewById(R.id.imagebtn2);
        imageButton2.setOnClickListener(new ImageButtonOnClick());
        imageButton3 = (ImageButton) findViewById(R.id.imagebtn3);
        imageButton4 = (ImageButton) findViewById(R.id.imagebtn4);
        imageButton3.setOnClickListener(new ImageButtonOnClick());
        imageButton4.setOnClickListener(new ImageButtonOnClick());
        imageButton5 = (ImageButton) findViewById(R.id.imagebtn5);
        imageButton6 = (ImageButton) findViewById(R.id.imagebtn6);
        imageButton5.setOnClickListener(new ImageButtonOnClick());
        imageButton6.setOnClickListener(new ImageButtonOnClick());
        imageButton7 = (ImageButton) findViewById(R.id.imagebtn7);
        imageButton7.setOnClickListener(new ImageButtonOnClick());

    }

    //    @Override
//    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        //当我这个界面绑定到窗口的时候
//        mHandler.post(mLooperTask);
//    }
//
//    @Override
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        Log.d(TAG, "onDetachedFromWindow");
//        mHandler.removeCallbacks(mLooperTask);
//    }
//
//    private Runnable mLooperTask = new Runnable() {
//        @Override
//        public void run() {
//            if (!mIsTouch) {
//                //切换viewPager里的图片到下一个
//                int currentItem = mLoopPager.getCurrentItem();
//                mLoopPager.setCurrentItem(++currentItem, true);
//            }
//            mHandler.postDelayed(this, 3000);
//        }
//    };
//
    class ImageButtonOnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.imagebtn1:
                    Intent intent = new Intent();
                    intent.setClass(IndexActivity.this, MedicalhistoryActivity.class);
                    startActivity(intent);
                    IndexActivity.this.finish();
                    break;
                case R.id.imagebtn2:
                    Intent intent2 = new Intent();
                    intent2.setClass(IndexActivity.this, Uploaddata.class);
                    startActivity(intent2);
                    IndexActivity.this.finish();
                    break;
                case R.id.imagebtn3:
                    Intent intent3 = new Intent();
                    intent3.setClass(IndexActivity.this, AppointmentActivity.class);
                    startActivity(intent3);
                    IndexActivity.this.finish();
                    break;
                case R.id.imagebtn4:
                    Intent intent4 = new Intent();
                    intent4.setClass(IndexActivity.this, AdvicesActivity.class);
                    startActivity(intent4);
                    IndexActivity.this.finish();
                    break;
                case R.id.imagebtn5:
                    Intent intent5 = new Intent();
                    intent5.setClass(IndexActivity.this, ConsultActivity.class);
                    startActivity(intent5);
                    IndexActivity.this.finish();
                    break;
                case R.id.imagebtn6:
                    Intent intent6 = new Intent();
                    intent6.setClass(IndexActivity.this, Healthmanage.class);
                    startActivity(intent6);
                    IndexActivity.this.finish();
                    break;
                case R.id.imagebtn7:
                    Intent intent7 = new Intent();
                    intent7.setClass(IndexActivity.this, PersonDataActivity.class);
                    startActivity(intent7);
                    IndexActivity.this.finish();
                    break;
            }
        }
    }
}

//    private void initView() {
//
//        //就是找到这个viewPager控件
//        mLoopPager = (MyViewPager) this.findViewById(R.id.looper_pager);
//        //设置适配器
//        mLooperPagerAdapter = new LooperPagerAdapter();
//        mLooperPagerAdapter.setData(sPics);
//        mLoopPager.setAdapter(mLooperPagerAdapter);
//        mLoopPager.setOnViewPagerTouchListener(this);
//        mLoopPager.addOnPageChangeListener(this);
//        mPointContainer = (LinearLayout) this.findViewById(R.id.points_container);
//        //根据图片的个数,去添加点的个数
//        insertPoint();
//        mLoopPager.setCurrentItem(mLooperPagerAdapter.getDataRealSize() * 100, false);
//
//    }
//
//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//        //这个方法的调用,其实是viewPager停下来以后选中的位置
//        int realPosition;
//        if (mLooperPagerAdapter.getDataRealSize() != 0) {
//            realPosition = position % mLooperPagerAdapter.getDataRealSize();
//        } else {
//            realPosition = 0;
//        }
//        setSelectPoint(realPosition);
//    }
//
//    private void insertPoint() {
//        for (int i = 0; i < sPics.size(); i++) {
//            View point = new View(this);
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(40, 40);
//            point.setBackground(getResources().getDrawable(R.drawable.shape_point_normal));
//            layoutParams.leftMargin = 20;
//            point.setLayoutParams(layoutParams);
//            mPointContainer.addView(point);
//        }
//    }
//
//    private void setSelectPoint(int realPosition) {
//        for (int i = 0; i < mPointContainer.getChildCount(); i++) {
//            View point = mPointContainer.getChildAt(i);
//            if (i != realPosition) {
//                //那就是白色
//                point.setBackgroundResource(R.drawable.shape_point_normal);
//            } else {
//                //选中的颜色
//                point.setBackgroundResource(R.drawable.shape_point_selected);
//            }
//        }
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//    }
//
//    @Override
//    public void onClick(View v) {
//
//    }
//
//    @Override
//    public void onPagerTouch(boolean isTouch) {
//
//    }
//}
