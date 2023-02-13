<%@ page language="java" pageEncoding="UTF-8" %>
<style>
    center a {
        text-decoration: none;
    }
</style>
<script type="text/javascript">
    //跳到第i页
    function gotoPage(i) {
        //var currentForm = document.getElementById("fm1");
        var currentPage = document.getElementById("currentPage");
        currentPage.value = i;
        //currentForm.submit(); //提交表单
        findList();
    }

    function pInit(page) {
        var ph = "";
        ph += "<input id='currentPage' type='hidden' name='currentPage' value='" + page.currentPage + "'>";
        ph += "   <a href='#' onclick='gotoPage(1)'>首页</a>&nbsp;&nbsp;";
        if (page.hasPrevious) {
            ph += "<a href='#' onclick='gotoPage(" + page.prePage + ")'>上一页</a>&nbsp;&nbsp;";
        } else {
            ph += "上一页&nbsp;&nbsp;";
        }
        if (page.hasNext) {
            ph += " <a href='#' onclick='gotoPage(" + page.nextPage + ")'>下一页</a>&nbsp;&nbsp;";
        } else {
            ph += "下一页&nbsp;&nbsp;";
        }
        ph += "<a href='#' onclick='gotoPage(" + page.totalPages + ")'>未页</a>&nbsp;&nbsp;";
        ph += "当前第<b>" + page.currentPage + "</b>页&nbsp;&nbsp;";
        ph += "每行有<b>" + page.rowsPerPage + "</b>页&nbsp;&nbsp;";
        ph += "总记录数:<b>" + page.totalRows + "</b>条&nbsp;&nbsp;";
        ph += "总页数:<b>" + page.totalPages + "</b>页&nbsp;&nbsp;";
        $("#ph").html(ph);
    }
</script>
<div id="ph" style="text-align: center;">
    <!-- 第一次查询需要 -->
    <input id='currentPage' type='hidden' name='currentPage' value='1'>
</div>
    
