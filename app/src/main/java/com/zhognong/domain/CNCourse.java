package com.zhognong.domain;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/4/5.
 */
@Entity
public class CNCourse {
    @Id(autoincrement = false)
    private String course_id;
    private String course_name;
    private String course_type;
    private String expired_date;
    private String is_class;
    private String lesson_count;
    private String lesson_download_count;
    private String parent_path;
    private String belong_user;
    private String parent_course;
    @Generated(hash = 1486220648)
    public CNCourse(String course_id, String course_name, String course_type,
            String expired_date, String is_class, String lesson_count,
            String lesson_download_count, String parent_path, String belong_user,
            String parent_course) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_type = course_type;
        this.expired_date = expired_date;
        this.is_class = is_class;
        this.lesson_count = lesson_count;
        this.lesson_download_count = lesson_download_count;
        this.parent_path = parent_path;
        this.belong_user = belong_user;
        this.parent_course = parent_course;
    }
    @Generated(hash = 75949404)
    public CNCourse() {
    }
    public String getCourse_id() {
        return this.course_id;
    }
    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
    public String getCourse_name() {
        return this.course_name;
    }
    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
    public String getCourse_type() {
        return this.course_type;
    }
    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }
    public String getExpired_date() {
        return this.expired_date;
    }
    public void setExpired_date(String expired_date) {
        this.expired_date = expired_date;
    }
    public String getIs_class() {
        return this.is_class;
    }
    public void setIs_class(String is_class) {
        this.is_class = is_class;
    }
    public String getLesson_count() {
        return this.lesson_count;
    }
    public void setLesson_count(String lesson_count) {
        this.lesson_count = lesson_count;
    }
    public String getLesson_download_count() {
        return this.lesson_download_count;
    }
    public void setLesson_download_count(String lesson_download_count) {
        this.lesson_download_count = lesson_download_count;
    }
    public String getParent_path() {
        return this.parent_path;
    }
    public void setParent_path(String parent_path) {
        this.parent_path = parent_path;
    }
    public String getBelong_user() {
        return this.belong_user;
    }
    public void setBelong_user(String belong_user) {
        this.belong_user = belong_user;
    }
    public String getParent_course() {
        return this.parent_course;
    }
    public void setParent_course(String parent_course) {
        this.parent_course = parent_course;
    }

}
