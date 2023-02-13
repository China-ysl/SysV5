<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>${_title}-顶部菜单</title>
        <link rel="stylesheet" type="text/css" href="${_css}/top.css"/>
        <script>
            function getTime() {
                //日期对象
                var now = new Date();
                var s = now.getFullYear() + "年";
                s += (now.getMonth() + 1) + "月";
                s += now.getDate() + "日";
                s += now.getHours() + "时";
                s += now.getMinutes() + "分";
                s += now.getSeconds() + "秒";
                var week = now.getDay();
                var weeks = ["", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"]

                document.getElementById("time").innerHTML = "当前时间:" + s + " " + weeks[week];
            }

            // 启动定时器，每秒调用一次函数
            window.setInterval("getTime();", 1000);
        </script>
    </head>
    <body>
        <div id="top">
            <div id="title">${_title}</div>
            <div id="logout">
                <%--<span>2022年3月17日18时</span>--%>
                <span id="username">当前用户:${sessionScope.user.name}</span>
                <span id="time"></span>
                <a href="${_ctx}/logout" onclick="return confirm('你确定退出吗?');" target="_top">退出系统</a>
            </div>
        </div>
    </body>
</html>
