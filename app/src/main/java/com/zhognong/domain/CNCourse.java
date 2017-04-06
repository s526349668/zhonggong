package com.zhognong.domain;

import org.greenrobot.greendao.annotation.Entity;

/**
 * Created by Administrator on 2017/4/5.
 */
@Entity(
        generateConstructors = true,
        generateGettersSetters = true
)
public class CNCourse {
    private String course_id;
    private String course_name;
    private String course_type;
    private String expired_date;
    private String is_class;
    private String lesson_count;
    private String lesson_download_count;
    private String parent_path;


}
