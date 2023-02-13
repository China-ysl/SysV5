package com.iflytek.sys.controller;

import com.iflytek.sys.bean.Page;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的描述:  控制器基类
 * 项目名称:  Sys_V40613
 * 类的包名:  com.iflytek.sys.controller
 * 创建的人:  农子科(296608517@qq.com)
 * 创建时间:  2022/6/14 21:26
 * 修改的人:  农子科(296608517@qq.com)
 * 修改时间:  2022/6/14 21:26
 * 修改备注:
 * 修订版本:  V1.0
 */
public class BaseController<E> {

    ServletContext sc;
    HttpServletRequest req;
    HttpServletResponse resp;
    HttpSession session;
    //请求参数
    E pd;
    //响应参数
    Map<String, Object> rm;
    boolean isUpdate;//表示是否是更新的提交
    private Page page;

    @ModelAttribute
    public void before(E obj, boolean isUpdate, Page page,
                       HttpServletRequest request,
                       HttpServletResponse response) {
        //System.out.println("------------------Controller前置处理()-------------------");
        this.req = request;
        this.resp = response;
        this.session = req.getSession();
        this.sc = request.getServletContext();
        this.pd = obj;
        this.rm = new HashMap<>();
        this.isUpdate = isUpdate;
        this.page = page;
    }

    /**
     * 异常处理类
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception e) {
        ModelAndView mv = new ModelAndView("common/pager");
        //把异常堆栈写到字符串对象中
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        mv.addObject("message", e.toString());//异常摘要
        mv.addObject("exceptionStack", sw.toString());//异常详情
        return mv;
    }

    //设置返回页面的提示信息
    public void setMsg(String msg) {
        rm.put("msg", msg);
    }

    //设置返回页面回显对象
    public void setObj(E obj) {
        rm.put("command", obj);
    }

    //设置返回页面的数据集合
    public void setList(List<E> list) {
        rm.put("list", list);
    }

    public Page getPage() {
        if (page == null) {
            page = new Page();
        }
        return page;
    }
}
