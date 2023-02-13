<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>用户更新页面</title>
        <link rel="stylesheet" href="${_css}/user.css" type="text/css">
    </head>
    <body onload="cUpdateInit(${param.id}, '${_ctx}/class/update')">
        <form id="form1">
            <input type="hidden" name="isUpdate" value="true">
            <input type="hidden" name="id" value="${requestScope.tClass.id}">

            <div id="div-list">
                <fieldset class="fset">
                    <legend>更新班级</legend>
                    <table border="0" align="center" width="100%">
                        <tr>
                            <td width="15%" align="right">姓名:</td>
                            <td width="35%">
                                <input type="text"
                                       name="name"
                                       placeholder="请输入班级名"/>
                            </td>
                            <td width="15%" align="right">用户名:</td>
                            <td width="35%">
                                <input type="text"
                                       name="charger"
                                       placeholder="请输入班主任名"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right"></td>
                            <td>
                                <input type="reset" value="重置"/>
                                <input type="button" value="提交" onclick="cUpdate('${_ctx}/class/update')"/>
                                <input type="button" value="返回" onclick="parent.closeDialog()"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </div>
        </form>
    </body>
</html>
