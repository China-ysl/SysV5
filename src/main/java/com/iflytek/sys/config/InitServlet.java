package com.iflytek.sys.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

/**
 * 类的描述:  系统启动类
 * 项目名称:  Sys_V1.0
 * 类的包名:  com.iflytek.sys.servleet
 * 创建的人:  农子科(296608517@qq.com)
 * 创建时间:  2022/4/29 11:29
 * 修改的人:  农子科(296608517@qq.com)
 * 修改时间:  2022/4/29 11:29
 * 修改备注:
 * 修订版本:  V1.0
 */
//用户注解配置servlet启动时自动加载，必须加value和loadOnStartup属性
//loadOnStartup启动顺序1,2,3数字起小就优先启动
@WebServlet(value = "/InitServlet", loadOnStartup = 1)
public class InitServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("系统启动初始化....");
        //获取应用程序的上下文对象
        ServletContext servletContext = config.getServletContext();

        //获取项目的根路径
        String rootPath = servletContext.getContextPath();
        System.out.println(rootPath);
        servletContext.setAttribute("_ctx", rootPath);
        servletContext.setAttribute("_css", rootPath + "/css");
        servletContext.setAttribute("_img", rootPath + "/images");
        servletContext.setAttribute("_ui", rootPath + "/ui");
        servletContext.setAttribute("_js", rootPath + "/js");
        servletContext.setAttribute("_title", "广西理工教务管理系统V5.0(SSM版本)");

        System.out.println("样式路径" + rootPath + "/css");

        try {
            //初始性别变量
            Map<String, String> map = new HashMap<>();
            map.put("1", "男");
            map.put("2", "女");
            servletContext.setAttribute("_sex", map);

            ObjectMapper mapper = new ObjectMapper();
            String mapJson = mapper.writeValueAsString(map);
            servletContext.setAttribute("_sexs", mapJson);

            //初始用户标记变量
            Map<String, String> lf = new HashMap<>();
            lf.put("1", "正常");
            lf.put("2", "冻结");
            servletContext.setAttribute("_lf", lf);

            String json_flag = mapper.writeValueAsString(lf);
            servletContext.setAttribute("_lfs", json_flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
