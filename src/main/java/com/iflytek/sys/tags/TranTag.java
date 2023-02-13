package com.iflytek.sys.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.util.Map;

/**
 * 类的描述:  翻译标签
 * 项目名称:  JspJstl0506
 * 类的包名:  com.iflytek.jstl
 * 创建的人:  农子科(296608517@qq.com)
 * 创建时间:  2022/5/9 10:08
 * 修改的人:  农子科(296608517@qq.com)
 * 修改时间:  2022/5/9 10:08
 * 修改备注:
 * 修订版本:  V1.0
 */
public class TranTag extends BodyTagSupport {

    //数据字典集
    private Map<String, String> data;

    private String value;

    @Override
    public int doStartTag() throws JspException {
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        //指向客户端的输出流
        JspWriter out = this.pageContext.getOut();
        try {
            if (data != null && data.get(value) != null) {
                out.write(data.get(value));
            } else {
                out.write("--");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;//执行标签后的内容;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
