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
public class CNCatalog {
   @Id(autoincrement = false)
   private String catalog_id;
   private String catalog_name;
   private String is_audition;
   private String learning_contents;
   private String learning_guide;
   private String learning_target;
   private String lesson_count;
   private String suggest_timelength;
   private String belong_course;
@Generated(hash = 1561524611)
public CNCatalog(String catalog_id, String catalog_name, String is_audition,
        String learning_contents, String learning_guide, String learning_target,
        String lesson_count, String suggest_timelength, String belong_course) {
    this.catalog_id = catalog_id;
    this.catalog_name = catalog_name;
    this.is_audition = is_audition;
    this.learning_contents = learning_contents;
    this.learning_guide = learning_guide;
    this.learning_target = learning_target;
    this.lesson_count = lesson_count;
    this.suggest_timelength = suggest_timelength;
    this.belong_course = belong_course;
}
@Generated(hash = 1305857450)
public CNCatalog() {
}
public String getCatalog_id() {
    return this.catalog_id;
}
public void setCatalog_id(String catalog_id) {
    this.catalog_id = catalog_id;
}
public String getCatalog_name() {
    return this.catalog_name;
}
public void setCatalog_name(String catalog_name) {
    this.catalog_name = catalog_name;
}
public String getIs_audition() {
    return this.is_audition;
}
public void setIs_audition(String is_audition) {
    this.is_audition = is_audition;
}
public String getLearning_contents() {
    return this.learning_contents;
}
public void setLearning_contents(String learning_contents) {
    this.learning_contents = learning_contents;
}
public String getLearning_guide() {
    return this.learning_guide;
}
public void setLearning_guide(String learning_guide) {
    this.learning_guide = learning_guide;
}
public String getLearning_target() {
    return this.learning_target;
}
public void setLearning_target(String learning_target) {
    this.learning_target = learning_target;
}
public String getLesson_count() {
    return this.lesson_count;
}
public void setLesson_count(String lesson_count) {
    this.lesson_count = lesson_count;
}
public String getSuggest_timelength() {
    return this.suggest_timelength;
}
public void setSuggest_timelength(String suggest_timelength) {
    this.suggest_timelength = suggest_timelength;
}
public String getBelong_course() {
    return this.belong_course;
}
public void setBelong_course(String belong_course) {
    this.belong_course = belong_course;
}


}
