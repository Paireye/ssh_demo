<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<title>用户登录</title>
</head>

<body>
	<a href="login.jsp">登录</a>
	<a href="register.jsp">注册</a>
	<form action="userlogin.action" method="post">
		<div>
			<label>用户名</label>
			<input type="text" name="uname" placeholder="username">
		</div>
		<div>
			<label>密码</label>
			<input type="text" name="upassword" placeholder="password">
		</div>
		<input type="submit" value="登录">
	</form>
	<div id="addnew"></div>
</body>

</html>