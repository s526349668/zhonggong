package com.zhognong.utils;

import android.os.Handler;

import com.google.gson.Gson;
import com.zhognong.domain.Course;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */

public class ParseUilts {
    public static Course result;
    public static void parseJson(Handler handler, String string) {
        Gson gson = new Gson();
        result = gson.fromJson(string, Course.class);
        List<Course.CourseInfo> sub_node=result.getSub_node();
        handler.sendMessage(handler.obtainMessage(1, sub_node));
    }
}
