package com.iflytek.sys.dao;

import com.iflytek.sys.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 类的描述:
 * 项目名称:  Sys_V30527AM
 * 类的包名:  com.iflytek.sys.dao
 * 创建的人:  农子科(296608517@qq.com)
 * 创建时间:  2022/5/27 9:48
 * 修改的人:  农子科(296608517@qq.com)
 * 修改时间:  2022/5/27 9:48
 * 修改备注:
 * 修订版本:  V1.0
 */
public interface IUserDao {

    List<User> login(@Param("username") String username, @Param("password") String password);

    List<User> findAllUserList(Map<String, Object> param);

    int add(User user);

    int delete(int id);

    User getUserById(int id);

    int update(User user);
}
