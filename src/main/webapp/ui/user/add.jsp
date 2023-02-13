<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>用户新增页面</title>
		<link rel="stylesheet" href="${_css}/user.css" type="text/css">
	</head>
	<body>
		<form id="form1">
			<div id="div-list">
				<fieldset class="fset">
					<legend>新增用户</legend>
					<table border="0" align="center" width="100%">
						<tr>
							<td width="15%" align="right">姓名:</td>
							<td width="35%">
								<input type="text" name="name" placeholder="请输入姓名" />
							</td>
							<td width="15%" align="right">用户名:</td>
							<td width="35%">
								<input type="text" name="username" placeholder="请输入用户名" />
							</td>
						</tr>
						<tr>
							<td width="15%" align="right">出生日期:</td>
							<td width="35%">
								<input type="date" id="birthday" name="birthday" placeholder="请选择出生日期">
							</td>
							<td width="15%" align="right">登录状态:</td>
							<td width="35%">
								<mt:selectTag name="loginFlag" data="${_lf}" cssClass="ipt"/>
							</td>
						</tr>
						<tr>
							<td align="right">性别:</td>
							<td>
								<mt:selectTag name="sex" data="${_sex}" cssClass="ipt"/>
							</td>
							<td align="right"></td>
							<td>
								<input type="reset" value="重置" />
								<input type="button" value="提交" onclick="cAdd('${_ctx}/user/add')" />
								<input type="button" value="返回" onclick="parent.closeDialog('')" />
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
		</form>
	</body>
</html>
