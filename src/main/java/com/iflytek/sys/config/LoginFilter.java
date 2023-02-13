package com.iflytek.sys.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 类的描述:  登录校验过滤器
 * 项目名称:  Sys_V1.0_0505
 * 类的包名:  com.iflytek.sys.config
 * 创建的人:  农子科(296608517@qq.com)
 * 创建时间:  2022/5/5 9:36
 * 修改的人:  农子科(296608517@qq.com)
 * 修改时间:  2022/5/5 9:36
 * 修改备注:
 * 修订版本:  V1.0
 */
@WebFilter({"*.jsp", "*.do"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();

        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if (uri.endsWith("login.jsp") ||
                uri.endsWith("login") ||
                uri.endsWith("register.jsp") ||
                uri.endsWith(request.getContextPath() + "/")) {
            //对于特殊请求进行放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (null != user) {
            //如果已经登录,则放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            request.setAttribute("msg", "未登录,没有权限访问");
            request.getRequestDispatcher("/ui/login.jsp").forward(request, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
