package com.exce.testtcp.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.exce.testtcp.R;

import java.util.ArrayList;

/**
 * @Author Wangjj
 * @Create 2018/4/23.
 * @Content
 */
public class HomePageActivity extends Activity {
    public static HomePageActivity instance = null;
    private ViewPager mTabPager;
    private ImageView mHomePage, mAdress, mMessage, mPersonl;
    private int zero = 0;
    private int currIndex = 0;
    private int one;
    private int two;
    private int three;
    private TextView tv_home, tv_address, tv_message, tv_mine;
    private LinearLayout linear_tab1, linear_tab2, linear_tab3, linear_tab4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_oa);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initView();
    }

    private void initView() {
        instance = this;
        mTabPager = (ViewPager) findViewById(R.id.tabpager);
        mTabPager.setOnPageChangeListener(new MyOnPageChangeListener());

        tv_home = (TextView) findViewById(R.id.tv_home);
        tv_address = (TextView) findViewById(R.id.tv_address);
        tv_message = (TextView) findViewById(R.id.tv_message);
        tv_mine = (TextView) findViewById(R.id.tv_mine);

        linear_tab1 = (LinearLayout) findViewById(R.id.liner_tab1);
        linear_tab2 = (LinearLayout) findViewById(R.id.liner_tab2);
        linear_tab3 = (LinearLayout) findViewById(R.id.liner_tab3);
        linear_tab4 = (LinearLayout) findViewById(R.id.liner_tab4);

        mHomePage = (ImageView) findViewById(R.id.image_homepage);
        mAdress = (ImageView) findViewById(R.id.image_address);
        mMessage = (ImageView) findViewById(R.id.image_message);
        mPersonl = (ImageView) findViewById(R.id.image_personl);

        mHomePage.setOnClickListener(new MyOnClickListener(0));
        mAdress.setOnClickListener(new MyOnClickListener(1));
        mMessage.setOnClickListener(new MyOnClickListener(2));
        mPersonl.setOnClickListener(new MyOnClickListener(3));

        Display currDisplay = getWindowManager().getDefaultDisplay();
        int displayWidth = currDisplay.getWidth();
        int displayHeight = currDisplay.getHeight();
        one = displayWidth / 4;
        two = one * 2;
        three = one * 3;

        LayoutInflater mLi = LayoutInflater.from(this);
        View view1 = mLi.inflate(R.layout.tab_homepage, null);
        View view2 = mLi.inflate(R.layout.tab_address, null);
        View view3 = mLi.inflate(R.layout.tab_message, null);
        View view4 = mLi.inflate(R.layout.tab_person, null);

        final ArrayList<View> views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);

        PagerAdapter mPagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public void destroyItem(View container, int position, Object object) {
                ((ViewPager) container).removeView(views.get(position));
            }

            @Override
            public Object instantiateItem(View container, int position) {
                ((ViewPager) container).addView(views.get(position));
                //return super.instantiateItem(container, position);
                return views.get(position);
            }
        };
        mTabPager.setAdapter(mPagerAdapter);
    }

    /**
     * 头标点击监听
     */
    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            mTabPager.setCurrentItem(index);
        }
    }

    /**
     * 页卡切换监听
     */

    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
                case 0:
                    mHomePage.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                    tv_home.setTextColor(getResources().getColor(R.color.green));
                    linear_tab1.setBackgroundColor(getResources().getColor(R.color.orange));
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(one, 0, 0, 0);
                        mAdress.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                        tv_address.setTextColor(getResources().getColor(R.color.a55a));
                        linear_tab2.setBackgroundColor(getResources().getColor(R.color.blue));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, 0, 0, 0);
                        mMessage.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                        tv_message.setTextColor(getResources().getColor(R.color.a55a));
                        linear_tab3.setBackgroundColor(getResources().getColor(R.color.blue));
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(three, 0, 0, 0);
                        mPersonl.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                        tv_mine.setTextColor(getResources().getColor(R.color.a55a));
                        linear_tab4.setBackgroundColor(getResources().getColor(R.color.blue));
                    }
                    break;
                case 1:
                    mAdress.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                    tv_address.setTextColor(getResources().getColor(R.color.green));
                    linear_tab2.setBackgroundColor(getResources().getColor(R.color.orange));
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(zero, one, 0, 0);
                        mHomePage.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                        tv_home.setTextColor(getResources().getColor(R.color.a55a));
                        linear_tab1.setBackgroundColor(getResources().getColor(R.color.blue));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, one, 0, 0);
                        mMessage.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                        tv_message.setTextColor(getResources().getColor(R.color.a55a));
                        linear_tab3.setBackgroundColor(getResources().getColor(R.color.blue));
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(three, one, 0, 0);
                        mPersonl.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                        tv_mine.setTextColor(getResources().getColor(R.color.a55a));
                        linear_tab4.setBackgroundColor(getResources().getColor(R.color.blue));
                    }
                    break;
                case 2:
                    mMessage.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                    tv_message.setTextColor(getResources().getColor(R.color.green));
                    linear_tab3.setBackgroundColor(getResources().getColor(R.color.orange));
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(zero, two, 0, 0);
                        mHomePage.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                        tv_home.setTextColor(getResources().getColor(R.color.a55a));
                        linear_tab1.setBackgroundColor(getResources().getColor(R.color.blue));
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, two, 0, 0);
                        mAdress.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                        tv_address.setTextColor(getResources().getColor(R.color.a55a));
                        linear_tab2.setBackgroundColor(getResources().getColor(R.color.blue));
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(three, two, 0, 0);
                        mPersonl.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                        tv_mine.setTextColor(getResources().getColor(R.color.a55a));
                        linear_tab4.setBackgroundColor(getResources().getColor(R.color.blue));
                    }
                    break;
                case 3:
                    mPersonl.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                    tv_mine.setTextColor(getResources().getColor(R.color.green));
                    linear_tab4.setBackgroundColor(getResources().getColor(R.color.orange));
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(zero, three, 0, 0);
                        mHomePage.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                        tv_home.setTextColor(getResources().getColor(R.color.a55a));
                        linear_tab1.setBackgroundColor(getResources().getColor(R.color.blue));
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, three, 0, 0);
                        mAdress.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                        tv_address.setTextColor(getResources().getColor(R.color.a55a));
                        linear_tab2.setBackgroundColor(getResources().getColor(R.color.blue));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, three, 0, 0);
                        mMessage.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                        tv_message.setTextColor(getResources().getColor(R.color.a55a));
                        linear_tab3.setBackgroundColor(getResources().getColor(R.color.blue));
                    }
                    break;
            }
            currIndex = arg0;
            animation.setFillAfter(true);
            animation.setDuration(150);
            //设置底部滑动动画
            // mTabImg.startAnimation(animation);
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    }

}


