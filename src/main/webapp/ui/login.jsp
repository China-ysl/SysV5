<%--
  Created by IntelliJ IDEA.
  User: Nongzike
  Date: 2022/4/29
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>${_title}-登录界面</title>

        <script type="text/javascript" src="${_js}/jquery-3.6.0.min.js"></script>

        <!-- 外部链接引入的方式 -->
        <%--pageContext  >  request  >  session > servletContext--%>
        <link rel="stylesheet" type="text/css" href="${_css}/login.css"/>
        <link rel="stylesheet" type="text/css" href="${_css}/common.css"/>

        <!-- 引入外部链js文件 -->
        <script src="${_js}/check.js" type="text/javascript" language="JavaScript"></script>

        <script type="text/javascript">
            function login() {
                if (checkAll()) {
                    var param = $("#form1").serialize();//序列化表单参数
                    //alert(param);

                    $.ajax(
                        {
                            type: "post",//请求方式
                            url: "${_ctx}/login",
                            data: param,
                            dataType: "json",//返回json的字符串自动的转换成js对象
                            success: function (data) {
                                //请求成功的回调
                                console.log("成功回调的数据", data);
                                if (1 === data.result) {
                                    //登录成功重定向到主页
                                    location.href = "${_ui}/index.jsp";
                                } else {
                                    $("#msg").html(data.msg);
                                }
                            },
                            error: function (e) {
                                console.log("失败回调的数据", e);
                                $("#msg").html("连接服务器失败");
                            }
                        }
                    );
                }
            }
        </script>
    </head>
    <body>
        <div id="login">
            <div id="title">${_title}</div>

            <div id="msg" class="err-span"></div>

            <form id="form1">
                <table border="0">
                    <tr>
                        <td width="35%" align="right">用户名:</td>
                        <td align="left">
                            <input type="text" name="username"
                                   placeholder="请输入用户名"
                                   class="ipt"
                                   alt="用户名"/>
                        </td>
                    </tr>

                    <tr>
                        <td width="35%" align="right">密&nbsp;&nbsp;&nbsp;码:</td>
                        <td align="left">
                            <input type="password" name="password"
                                   placeholder="请输入密码"
                                   class="ipt"
                                   alt="密码"/>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td align="left">
                            <!-- ctrl + shift + R : 复制一行-->
                            <input type="button" value="登录" onclick="login()"/>&nbsp;&nbsp;&nbsp;
                            <input type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;
                            <input type="button" value="注册" onclick="location.href='${_ui}/register.jsp'"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <script>
            //checkByName('username')
            checkByNameArr(['username', 'password'])
        </script>
    </body>
</html>

