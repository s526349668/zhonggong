package com.zhognong.domain;

import com.zhognong.dao.CNCourseDao;
import com.zhognong.dao.CNUserDao;
import com.zhognong.dao.DaoSession;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

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
    @ToMany(referencedJoinProperty = "belong_user")
    private List<CNCourse> cnCourses;
/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;
/** Used for active entity operations. */
@Generated(hash = 171102130)
private transient CNUserDao myDao;
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
/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 283279862)
public List<CNCourse> getCnCourses() {
    if (cnCourses == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        CNCourseDao targetDao = daoSession.getCNCourseDao();
        List<CNCourse> cnCoursesNew = targetDao._queryCNUser_CnCourses(user_id);
        synchronized (this) {
            if (cnCourses == null) {
                cnCourses = cnCoursesNew;
            }
        }
    }
    return cnCourses;
}
/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1273673464)
public synchronized void resetCnCourses() {
    cnCourses = null;
}
/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 128553479)
public void delete() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.delete(this);
}
/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 1942392019)
public void refresh() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.refresh(this);
}
/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 713229351)
public void update() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.update(this);
}
/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 703028144)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getCNUserDao() : null;
}


}
