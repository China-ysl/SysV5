package com.iflytek.sys.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 类的描述:  用户
 * 项目名称:  Sys_V1_0505PM
 * 类的包名:  com.iflytek.sys.bean
 * 创建的人:  农子科(296608517@qq.com)
 * 创建时间:  2022/5/5 15:27
 * 修改的人:  农子科(296608517@qq.com)
 * 修改时间:  2022/5/5 15:27
 * 修改备注:
 * 修订版本:  V1.0
 */
public class User {

    private int id;

    private String name;

    private int sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String username;

    private String password;

    private int loginFlag;

    private int roleId;

    private String filePath;

    @JsonFormat(pattern = "yyyy年MM月dd")
    private Date createDate;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(int loginFlag) {
        this.loginFlag = loginFlag;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", loginFlag=" + loginFlag +
                ", roleId=" + roleId +
                ", filePath='" + filePath + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
