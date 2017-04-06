package com.zhognong.domain;

import org.greenrobot.greendao.annotation.Entity;

/**
 * Created by Administrator on 2017/4/5.
 */
@Entity(
        generateConstructors = true,
        generateGettersSetters = true
)
public class CNCatalog {
   private String catalog_id;
   private String catalog_name;
   private String is_audition;



}
