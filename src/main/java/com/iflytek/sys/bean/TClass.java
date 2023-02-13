package com.iflytek.sys.bean;

import java.util.Date;

/**
 * 类的描述:  班级实体类
 * 项目名称:  Sys_V1_0505PM
 * 类的包名:  com.iflytek.sys.bean
 * 创建的人:  农子科(296608517@qq.com)
 * 创建时间:  2022/5/5 15:27
 * 修改的人:  农子科(296608517@qq.com)
 * 修改时间:  2022/5/5 15:27
 * 修改备注:
 * 修订版本:  V1.0
 */
public class TClass {

    private int id;

    private String name;

    private String charger;

    private Date createDate;

    public TClass() {
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

    public String getCharger() {
        return charger;
    }

    public void setCharger(String charger) {
        this.charger = charger;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "TClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", charger='" + charger + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
