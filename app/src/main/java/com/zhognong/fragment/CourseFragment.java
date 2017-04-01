package com.zhognong.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhognong.MyFragment;
import com.zhognong.R;
import com.zhognong.TabFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */
public class CourseFragment extends Fragment{
    private String[] titles = new String[]{"我的课班", "下载管理", "学习记录"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.course_fragment, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        List<Fragment> fragments = new ArrayList<Fragment>();
        for (int i = 0; i < titles.length; i++) {
            Fragment fragment = new MyFragment();
            Bundle bundle = new Bundle();
            bundle.putString("text",titles[i]);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        viewPager.setAdapter(new TabFragmentAdapter(fragments, titles, this.getFragmentManager(),getActivity()));
        TabLayout tablayout = (TabLayout)view.findViewById(R.id.tablayout);
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabTextColors(getResources().getColor(R.color.dark_white), Color.BLACK);
        return view;
    }
}
