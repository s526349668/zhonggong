package com.zhognong.utils;

import android.os.Handler;

import com.google.gson.Gson;
import com.zhognong.domain.Course;

/**
 * Created by Administrator on 2017/3/31.
 */

public class ParseUilts {
    public static Course result;
    public static void parseJson(Handler handler, String string) {
        Gson gson = new Gson();
        result = gson.fromJson(string, Course.class);
        int code=result.getCode();
        if(code==0){
            handler.sendMessage(handler.obtainMessage(1, result.getData().getSub_courses()));
        }

    }
}
