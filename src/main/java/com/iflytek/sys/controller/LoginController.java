package com.iflytek.sys.controller;

import com.iflytek.sys.bean.User;
import com.iflytek.sys.dao.IUserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的描述:
 * 项目名称:  Sys_V1.0_0505
 * 类的包名:  com.iflytek.sys.servleet
 * 创建的人:  农子科(296608517@qq.com)
 * 创建时间:  2022/5/5 9:45
 * 修改的人:  农子科(296608517@qq.com)
 * 修改时间:  2022/5/5 9:45
 * 修改备注:
 * 修订版本:  V1.0
 */
@Controller
public class LoginController {

    private Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    private IUserDao userDao;

    /**
     * 用户登录
     */
    @ResponseBody
    @RequestMapping("/login")
    private Object login(String username, String password, HttpSession session) {
        System.out.println("-----------------用户登录中-------------------");
        Map<String, Object> map = new HashMap<>();
        map.put("result", 0);//默认登录失败
        String msg = null;
        if (null != username && null != password) {
            //给业务逻辑层处理用户信息查询
            List<User> list = userDao.login(username, password);

            if (0 < list.size()) {
                User user = list.get(0);
                //登录成功
                map.put("result", 1);
                session.setAttribute("user", user);//把登录信息放到会话对象中
            } else {
                msg = "用户名或密码错误";
                logger.error("用户名或密码不正确username = " + username + ",password" + password);
            }
        } else {
            msg = "请传入正确的参数";
            logger.error("请传入正确的参数username = " + username + ",password" + password);
        }
        map.put("msg", msg);
        return map;
    }

    /**
     * 用户退出
     *
     */
    @RequestMapping("/logout")
    private void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------------退出登录--------------------");
        req.setAttribute("msg", "用户正常退出");
        HttpSession session = req.getSession();
        session.removeAttribute("user");//清除用户信息
        session.invalidate();//让会话失效
        //请求转发
        req.getRequestDispatcher("ui/login.jsp").forward(req, resp);
    }
}
