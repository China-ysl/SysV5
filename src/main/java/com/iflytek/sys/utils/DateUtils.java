package com.iflytek.sys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类的描述:  日期转换工具类
 * 项目名称:  Sys_V1_0506AM
 * 类的包名:  com.iflytek.sys.utils
 * 创建的人:  农子科(296608517@qq.com)
 * 创建时间:  2022/5/6 9:40
 * 修改的人:  农子科(296608517@qq.com)
 * 修改时间:  2022/5/6 9:40
 * 修改备注:
 * 修订版本:  V1.0
 */
public final class DateUtils {

    public static Date str2Date(String dateStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        //把字符串解析成日期类型
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
//            date = new Date();
        }
        return date;
    }

    public static String date2Str(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String str = sdf.format(date);
        return str;
    }
}
