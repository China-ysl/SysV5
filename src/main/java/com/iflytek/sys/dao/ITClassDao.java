package com.iflytek.sys.dao;

import com.iflytek.sys.bean.TClass;

import java.util.List;
import java.util.Map;

/**
 * 类的描述:
 * 项目名称:  Sys_V30527AM
 * 类的包名:  com.iflytek.sys.dao
 * 创建的人:  农子科(296608517@qq.com)
 * 创建时间:  2022/5/27 9:50
 * 修改的人:  农子科(296608517@qq.com)
 * 修改时间:  2022/5/27 9:50
 * 修改备注:
 * 修订版本:  V1.0
 */
public interface ITClassDao {
    List<TClass> findAllTClassList(Map<String, Object> param);

    int add(TClass tClass);

    int delete(int id);

    TClass getTClassById(int id);

    int update(TClass tClass);
}
