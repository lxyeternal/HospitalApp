package com.example.guoxiaowen.hospital;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;




import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

//主页面的文件

public class IndexActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnTouchListener{

    public static final int VIEW_PAGER_DELAY = 2000;
    private MyPagerAdapter mAdapter;
    private List<ImageView> mItems;
    private ImageView[] mBottomImages;
    private LinearLayout mBottomLiner;
    private ViewPager mViewPager;
    private ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7;

    private int currentViewPagerItem;
    //是否自动播放
    private boolean isAutoPlay;

    private MyHandler mHandler;
    private Thread mThread;


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

        mHandler = new MyHandler(this);
        //配置轮播图ViewPager
        mViewPager = ((ViewPager) findViewById(R.id.live_view_pager));
        mItems = new ArrayList<>();
        mAdapter = new MyPagerAdapter(mItems, this);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnTouchListener(this);
        mViewPager.addOnPageChangeListener(this);
        isAutoPlay = true;

        //TODO: 添加ImageView
        addImageView();
        mAdapter.notifyDataSetChanged();
        //设置底部4个小点
        setBottomIndicator();


    }
    private void addImageView(){
        ImageView view0 = new ImageView(this);
        view0.setImageResource(R.mipmap.pic0);
        ImageView view1 = new ImageView(this);
        view1.setImageResource(R.mipmap.pic1);
        ImageView view2 = new ImageView(this);
        view2.setImageResource(R.mipmap.pic2);

        view0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view2.setScaleType(ImageView.ScaleType.CENTER_CROP);

        mItems.add(view0);
        mItems.add(view1);
        mItems.add(view2);

    }

    private void setBottomIndicator() {
        //获取指示器(下面三个小点)
        mBottomLiner = (LinearLayout) findViewById(R.id.live_indicator);
        //右下方小圆点
        mBottomImages = new ImageView[mItems.size()];
        for (int i = 0; i < mBottomImages.length; i++) {
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            params.setMargins(5, 0, 5, 0);
            imageView.setLayoutParams(params);
            //如果当前是第一个 设置为选中状态
            if (i == 0) {
                imageView.setImageResource(R.drawable.indicator_select);
            } else {
                imageView.setImageResource(R.drawable.indicator_no_select);
            }
            mBottomImages[i] = imageView;
            //添加到父容器
            mBottomLiner.addView(imageView);
        }

        //让其在最大值的中间开始滑动, 一定要在 mBottomImages初始化之前完成
        int mid = MyPagerAdapter.MAX_SCROLL_VALUE / 2;
        mViewPager.setCurrentItem(mid);
        currentViewPagerItem = mid;

        //定时发送消息
        mThread = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true) {
                    mHandler.sendEmptyMessage(0);
                    try {
                        Thread.sleep(IndexActivity.VIEW_PAGER_DELAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        mThread.start();
    }






    ///////////////////////////////////////////////////////////////////////////
    // ViewPager的监听事件
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        currentViewPagerItem = position;
        if (mItems != null) {
            position %= mBottomImages.length;
            int total = mBottomImages.length;

            for (int i = 0; i < total; i++) {
                if (i == position) {
                    mBottomImages[i].setImageResource(R.drawable.indicator_select);
                } else {
                    mBottomImages[i].setImageResource(R.drawable.indicator_no_select);
                }
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                isAutoPlay = false;
                break;
            case MotionEvent.ACTION_UP:
                isAutoPlay = true;
                break;
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 为防止内存泄漏, 声明自己的Handler并弱引用Activity
    ///////////////////////////////////////////////////////////////////////////
    private static class MyHandler extends Handler {
        private WeakReference<IndexActivity> mWeakReference;

        public MyHandler(IndexActivity activity) {
            mWeakReference = new WeakReference<IndexActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    IndexActivity activity = mWeakReference.get();
                    if (activity.isAutoPlay) {

                        activity.mViewPager.setCurrentItem(++activity.currentViewPagerItem);
                    }

                    break;
            }

        }
    }


    class ImageButtonOnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.imagebtn1:
                    Intent intent = new Intent();
                    intent.setClass(IndexActivity.this, MedicalhistoryActivity.class);  //上传病历
                    startActivity(intent);
                    IndexActivity.this.finish();
                    break;
                case R.id.imagebtn2:
                    Intent intent2 = new Intent();
                    intent2.setClass(IndexActivity.this, Uploaddata.class);     //上传复诊数据
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

