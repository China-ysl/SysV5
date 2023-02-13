package com.iflytek.sys.bean;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 类的描述:
 * 项目名称:  Sys_V30527AM
 * 类的包名:  com.iflytek.sys.bean
 * 创建的人:  农子科(296608517@qq.com)
 * 创建时间:  2022/5/27 9:39
 * 修改的人:  农子科(296608517@qq.com)
 * 修改时间:  2022/5/27 9:39
 * 修改备注:
 * 修订版本:  V1.0
 */
public class TClassMapper implements RowMapper<TClass> {

    @Override
    public TClass mapRow(ResultSet rs, int i) throws SQLException {
        TClass tClass = new TClass();
        //把数据库的数据转成javaBean类
        tClass.setId(rs.getInt("id"));
        tClass.setName(rs.getString("name"));
        tClass.setCharger(rs.getString("charger"));
        tClass.setCreateDate(rs.getDate("create_date"));
        return tClass;
    }
}
