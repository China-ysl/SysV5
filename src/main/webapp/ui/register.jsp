<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>${_title}-注册界面</title>
		<!-- 外部引入样式方式 -->
		<link rel="stylesheet" type="text/css" href="${_css}/register.css" />
		<link rel="stylesheet" type="text/css" href="${_css}/common.css" />
		<!-- 引入外部链js文件 -->
		<script src="${_js}/check.js" type="text/javascript" language="JavaScript"></script>
	</head>
	<body>
		<div id="register">
			<span class="title">用户注册界面</span>
			<form id="form1" action="index.html" method="get">
				<table border="0" align="center">
					<tr>
						<td align="right">姓名:</td>
						<td align="left">
							<input type="text" placeholder="请输入姓名" name="name" alt="姓名" />
						</td>
					</tr>

					<tr>
						<td align="right">用户名:</td>
						<td align="left">
							<input type="text" placeholder="请输入用户名" name="username" alt="用户名" />
						</td>
					</tr>

					<tr>
						<td align="right">性别:</td>
						<td align="left">
							<select name="sex" class="sex">
								<option value="1">男</option>
								<option value="2">女</option>
							</select>
						</td>
					</tr>

					<tr>
						<td align="right">出生日期:</td>
						<td align="left">
							<input type="date" placeholder="请输入出生日期" name="birthday" alt="出生日期" />
						</td>
					</tr>

					<tr>
						<td align="right">电话:</td>
						<td align="left">
							<input type="text" placeholder="请输入电话" name="tel" alt="电话" />
						</td>
					</tr>

					<tr>
						<td align="right">密码:</td>
						<td align="left">
							<input type="password" placeholder="请输入密码" name="password" alt="密码" />
						</td>
					</tr>

					<tr>
						<td></td>
						<td>
							<input type="submit" value="注册" />&nbsp;&nbsp;&nbsp;
							<input type="reset" value="重置" />&nbsp;&nbsp;&nbsp;
							<input type="button" value="返回"
								onclick="window.location.href='${_ui}/login.jsp'" />&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
				</table>
			</form>
		</div>
		<script>
			//checkByName('username')
			checkByNameArr(['name', 'username', 'password', 'birthday', 'tel'])
		</script>
	</body>
</html>
