<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>${_title}-首页</title>
    </head>
    <!-- framset页面框架 -->
    <frameset rows="175px,*" frameborder="0">

        <frame src="top.jsp" noresize="noresize" scrolling="no"/>

        <frameset cols="182px,*" frameborder="0">
            <frame src="left.jsp" noresize="noresize"/>
            <frame src="welcome.jsp" noresize="noresize" name="main"/>
        </frameset>
    </frameset>
</html>

