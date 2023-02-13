package com.iflytek.sys.bean;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 类的描述:
 * 项目名称:  Sys_V30527AM
 * 类的包名:  com.iflytek.sys.bean
 * 创建的人:  农子科(296608517@qq.com)
 * 创建时间:  2022/5/27 8:50
 * 修改的人:  农子科(296608517@qq.com)
 * 修改时间:  2022/5/27 8:50
 * 修改备注:
 * 修订版本:  V1.0
 */
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        //把数据库的数据转成javaBean类
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setSex(rs.getInt("sex"));
        user.setBirthday(rs.getDate("birthday"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setLoginFlag(rs.getInt("login_flag"));
        user.setRoleId(rs.getInt("role_id"));
        user.setFilePath(rs.getString("file_path"));
        user.setCreateDate(rs.getDate("create_date"));
        return user;
    }
}
