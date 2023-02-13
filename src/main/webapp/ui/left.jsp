<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>${_title}-左边菜单栏</title>
		<link type="text/css" href="${_css}/left.css" rel="stylesheet" />
	</head>
	<body>
		<div id="menu">

			<h1 onclick="showMenu(this)"><a href="#">系统管理</a></h1>
			<ul class="menu-ul">
				<li><a href="${_ui}/user/list.jsp" target="main">用户管理</a></li>
				<li><a href="${_ui}/class/list.jsp" target="main">班级管理</a></li>
				<li><a href="#">部门管理</a></li>
				<li><a href="#">字典管理</a></li>
			</ul>


			<h1 onclick="showMenu(this)"><a href="#">产品管理</a></h1>
			<ul style="display: none;" class="menu-ul">
				<li><a>用户管理</a></li>
				<li><a>角色管理</a></li>
				<li><a>部门管理</a></li>
				<li><a>字典管理</a></li>
			</ul>


			<h1 onclick="showMenu(this)"><a href="#">订单管理</a></h1>
			<ul style="display: none;" class="menu-ul">
				<li><a>用户管理</a></li>
				<li><a>角色管理</a></li>
				<li><a>部门管理</a></li>
				<li><a>字典管理</a></li>
			</ul>
		</div>
		
<%--		<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
		<script type="text/javascript" src="${_js}/jquery-3.6.0.min.js"></script>
		<script>
			$(document).ready(function() {
				$("#menu .menu-ul:eq(0)").show();
				$("#menu h1").click(function() {
					$(this).next(".menu-ul").slideToggle(200).siblings(".menu-ul")
						.slideUp("slow");
				});
			});
		</script>

		<%--<script>
			function showMenu(obj) {
				console.log("-----", obj);
				console.log("-----obj下一个节点", obj.nextSibling);
				console.log("-----obj下一个节点的下一个节点", obj.nextSibling.nextSibling);

				var ulObj = obj.nextSibling.nextSibling;

				var objs = document.getElementsByClassName('menu-ul');
				console.log("-----", objs);
				for (var i = 0; i < objs.length; i++) {
					if (ulObj == objs[i]) {
						//如果objs[i]等于ulObj就会显示ulObj
						ulObj.style.display = 'block';
					} else {
						objs[i].style.display = 'none';
					}
				}
			}
		</script>--%>
	</body>
</html>
