package com.zhognong;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zhognong.adapter.LeftMenuAdapter;
import com.zhognong.adapter.SpaceItemDecoration;
import com.zhognong.fragment.CourseFragment;
import com.zhognong.fragment.ExamFragment;
import com.zhognong.fragment.LiveFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup navigationBar;
    private RadioButton coursebtn, examebtn, liveebtn;
    private Fragment courseFragment,examFragment,liveFragment;
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private RecyclerView lvLeftMenu;
    private Fragment mFragment;//当前显示的Fragment
    private AnimationDrawable mAnimationDrawable;
    private LeftMenuAdapter  leftMenuAdapter;
    private String[] lvs = {"绑定到本机", "关于我们", "反馈问题", "清理存储","检查更新(v1.0.0)","退出登录"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        toolbar.setTitle("中公网校-我的课程");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#000000")); //设置标题颜色
        toolbar.setTitleTextAppearance(this,R.style.Toolbar_TitleText);
        //toolbar.setNavigationIcon(R.mipmap.home);//设置导航栏图标
        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, 0, 0) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
       //mDrawerToggle.setDrawerIndicatorEnabled(false);
       // mDrawerToggle.setHomeAsUpIndicator(R.mipmap.home);
        //toolbar.setNavigationIcon(R.mipmap.home);//设置导航栏图标
      //  mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        List<String> menus=new ArrayList<String>();
        //设置菜单列表
        for (String lv:lvs){
            menus.add(lv);
        }
        lvLeftMenu.setLayoutManager(new LinearLayoutManager(this));
        leftMenuAdapter=new LeftMenuAdapter(MainActivity.this,menus);
        lvLeftMenu.setAdapter(leftMenuAdapter);
        lvLeftMenu.addItemDecoration(new SpaceItemDecoration(1,1));
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.main_fragment,courseFragment).commit();
        mFragment = courseFragment;
    }

    private void initViews() {
        navigationBar = (RadioGroup) findViewById(R.id.navigation_btn);
        coursebtn = (RadioButton) findViewById(R.id.coursebtn);
        examebtn = (RadioButton) findViewById(R.id.examebtn);
        liveebtn = (RadioButton) findViewById(R.id.liveebtn);
        navigationBar.setOnCheckedChangeListener(this);
        toolbar = (Toolbar) findViewById(R.id.tl_custom);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_left);
        lvLeftMenu = (RecyclerView) findViewById(R.id.lv_left_menu);
        courseFragment = new CourseFragment();
        examFragment = new ExamFragment();
        liveFragment = new LiveFragment();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.coursebtn:
                switchFragment(courseFragment);
                break;
            case R.id.examebtn:
                switchFragment(examFragment);
                break;
            case R.id.liveebtn:
                switchFragment(liveFragment);

                break;
        }
    }

    private void switchFragment(Fragment fragment) {
        //判断当前显示的Fragment是不是切换的Fragment
        if(mFragment != fragment) {
            //判断切换的Fragment是否已经添加过
            if (!fragment.isAdded()) {
                //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                getSupportFragmentManager().beginTransaction().hide(mFragment)
                        .add(R.id.main_fragment,fragment).commit();
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                getSupportFragmentManager().beginTransaction().hide(mFragment).show(fragment).commit();
            }
            mFragment = fragment;
        }
    }

}
