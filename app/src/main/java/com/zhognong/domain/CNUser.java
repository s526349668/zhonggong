package com.zhognong.domain;

import org.greenrobot.greendao.annotation.Entity;

/**
 * Created by Administrator on 2017/4/5.
 */
@Entity(
        generateConstructors = true,
        generateGettersSetters = true
)
public class CNUser {
    private String device_id;
    private String is_login;
    private String user_id;
    private String user_name;
    private String user_passord;
    private String user_tocket;


}
