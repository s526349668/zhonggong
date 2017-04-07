package com.zhognong.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

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
    @Id(autoincrement = false)
    private String user_id;
    private String user_name;
    private String user_passord;
    private String user_tocket;
@Generated(hash = 895468976)
public CNUser(String device_id, String is_login, String user_id,
        String user_name, String user_passord, String user_tocket) {
    this.device_id = device_id;
    this.is_login = is_login;
    this.user_id = user_id;
    this.user_name = user_name;
    this.user_passord = user_passord;
    this.user_tocket = user_tocket;
}
@Generated(hash = 477768813)
public CNUser() {
}
public String getDevice_id() {
    return this.device_id;
}
public void setDevice_id(String device_id) {
    this.device_id = device_id;
}
public String getIs_login() {
    return this.is_login;
}
public void setIs_login(String is_login) {
    this.is_login = is_login;
}
public String getUser_id() {
    return this.user_id;
}
public void setUser_id(String user_id) {
    this.user_id = user_id;
}
public String getUser_name() {
    return this.user_name;
}
public void setUser_name(String user_name) {
    this.user_name = user_name;
}
public String getUser_passord() {
    return this.user_passord;
}
public void setUser_passord(String user_passord) {
    this.user_passord = user_passord;
}
public String getUser_tocket() {
    return this.user_tocket;
}
public void setUser_tocket(String user_tocket) {
    this.user_tocket = user_tocket;
}


}
