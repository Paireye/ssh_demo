<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/register.js"></script>
</head>
<body>
	<a href="login.jsp">登录</a>
	<a href="register.jsp">注册</a>
	<form action="userregister.action" id="form">
		<div>
			<label>用户名</label>
			<input type="text" name="uname" id="code" placeholder="username" onblur="register()">
			<span id="message"></span>
		</div>
		<div>
			<label>密码</label>
			<input type="text" name="upassword" id="pwd" placeholder="password">
		</div>
		<input type="submit" value="注册">
	</form>
</body>
</html>