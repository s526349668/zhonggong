package com.zhognong.domain;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */

public class Course {
    private int code;
    private String msg;
    private CourseInfo data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CourseInfo getData() {
        return data;
    }

    public void setData(CourseInfo data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class CourseInfo{
        private String course_id;
        private String course_name;
        private String course_type;
        private String is_class;
        private String expired_date;
        private List<CourseInfo> sub_courses;
        private boolean isRoot;
        private int level;

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public boolean isRoot() {
            return isRoot;
        }

        public void setRoot(boolean root) {
            isRoot = root;
        }

        public String getCourse_id() {
            return course_id;
        }

        public void setCourse_id(String course_id) {
            this.course_id = course_id;
        }

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public String getCourse_type() {
            return course_type;
        }

        public void setCourse_type(String course_type) {
            this.course_type = course_type;
        }

        public String getIs_class() {
            return is_class;
        }

        public void setIs_class(String is_class) {
            this.is_class = is_class;
        }

        public String getExpired_date() {
            return expired_date;
        }

        public void setExpired_date(String expired_date) {
            this.expired_date = expired_date;
        }

        public List<CourseInfo> getSub_courses() {
            return sub_courses;
        }

        public void setSub_courses(List<CourseInfo> sub_courses) {
            this.sub_courses = sub_courses;
        }
    }
}
