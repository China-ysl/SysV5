<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../common/header.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>班级列表</title>
        <link rel="stylesheet" type="text/css" href="${_css}/user.css"/>

        <!-- 引入弹出窗口JS库 -->
        <script type="text/javascript" src="${_ui}/common/lhgdialog/lhgdialog.min.js?self=true&skin=igreen"></script>

        <script type="text/javascript">

            function tipDialog() {
                /*var flag = false;
                $.dialog.confirm('你确定要删除吗？', function(){

                }, function(){
                    $.dialog.tips('执行取消操作');
                });*/
            }

            function findList() {
                var param = $("#form1").serialize();//序列化表单参数
                $.ajax({
                    type: "post",
                    url: "${_ctx}/class/list",
                    data: param,
                    dataType: "json",//返回json的字符串自动的转换成js对象
                    success: function (data) {
                        //删除所有class属性以tr开头的行
                        $("tr[class^=tr]").remove();
                        //请求成功的回调
                        console.log("成功回调的数据", data);

                        //JSON.stringify()//把对象转成json字符串(序列化)
                        //解析json,就是把字符串转成js对象
                        // var list = JSON.parse(data.list)
                        pInit(data.page);//初始化分页菜单
                        $(data.list).each(
                            function (i, item) {//v是DOM对象
                                var newTr = $("#rw").clone();
                                newTr.attr("class", "tr" + (i % 2));
                                newTr.show();
                                var tds = newTr.find("td");
                                tds.eq(0).html(item.id);
                                tds.eq(1).html(item.name);
                                tds.eq(2).html(item.charger);
                                tds.eq(3).html(item.createDate);
                                tds.eq(4).html("<a href=\"javascript:cDelete('${_ctx}/class/delete?id=" + item.id + "');\"" +
                                    " onclick=\"return confirm('确认删除吗?');\" >删除</a>｜" +
                                    "<a href=\"javascript:openDialog('班级更新','${_ui}/class/update.jsp?id=" + item.id + "');\">更新</a>");
                                $("table[class=tab_list]").append(newTr);
                            }
                        );
                    },
                    error: function (e) {
                        console.log("失败回调的数据", e);
                    }
                })
            }
        </script>
    </head>
    <body onload="findList()">
        <form id="form1">
            <div id="div-list">
                <fieldset class="fset">
                    <legend>查询条件</legend>
                    <table width="100%" align="center" border="0">
                        <tr>
                            <td width="15%" align="right">班级名:</td>
                            <td width="20%">
                                <input type="text" placeholder="请输入班级名" name="name"/>
                            </td>
                            <td width="15%" align="right">班主任:</td>
                            <td width="20%">
                                <input type="text" placeholder="请输入班主任名" name="charger"/>
                            </td>
                        </tr>

                        <tr>
                            <td width="15%"></td>
                            <td width="35%">
                                <input type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;
                                <input type="button" value="查询" onclick="findList()"/>&nbsp;&nbsp;&nbsp;
                                <input type="button" value="新增" onclick="openDialog('新增用户', '${_ui}/class/add.jsp')"/>
                            </td>
                        </tr>

                    </table>
                </fieldset>


                <fieldset class="fset">
                    <table width="100%" align="center" border="1" class="tab_list">
                        <tr>
                            <td style="background-color: #ADFF2F">
                                <span style="color: red;">${requestScope.msg}</span>
                            </td>
                            <th colspan="4">班级信息列表</th>
                        </tr>

                        <tr>
                            <th>班级ID</th>
                            <th>班级名</th>
                            <th>班主任</th>
                            <th>创建日期</th>
                            <th>操作</th>
                        </tr>

                        <%--<c:forEach var="obj" items="${requestScope.list}" varStatus="vs">
                            <tr class="tr${vs.index % 2}">
                                <td>${obj.id}</td>
                                <td>${obj.name}</td>
                                <td>${obj.charger}</td>
                                <td>${obj.createDate}</td>
                                <td>
                                    <a href="${_ctx}/class_delete.do?id=${obj.id}"
                                       onclick="return confirm('确认删除吗?');">删除</a>
                                    <a href="${_ctx}/class_update.do?id=${obj.id}">更新</a>
                                </td>
                            </tr>
                        </c:forEach>--%>

                        <tr id="rw" style="display: none;">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                    <%@ include file="../common/pager.jsp" %>
                </fieldset>
            </div>
        </form>
    </body>
</html>
