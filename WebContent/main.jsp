<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<style type="text/css">
a {
	text-decoration: none;
	color: #2F4F4F;
}

a:hover {
	color: #7FFF00;
}

a:active {
	color: #218868;
}

a:after {
	color: #2F4F4F;
}
</style>
</head>
<body>
	<h1 align="center">用户管理</h1>
	<div style="margin: 0 auto; border: 0 solid #0000FF">

		<table id="content" border="0" align="center" bordercolor="blue">
			<tr>
				<td>
					<h3>
						<a href="javascript:;" onclick="insert()">新增</a>
						<a href="userreload.action">刷新</a>
					</h3>
				</td>
				<td colspan="2">
					<h4>用户：${user.uname} &nbsp; &nbsp; &nbsp; &nbsp;密码：${user.upassword}</h4>
				</td>
				<td>
					<h3>
						<a href="userclearSession.action">退出</a>
					</h3>
				</td>

			</tr>
			<tr>
				<td>id</td>
				<td>name</td>
				<td>password</td>
				<td>operate</td>
			</tr>
			<c:forEach items="${users }" var="use">
				<tr>
					<td>
						<input class="use${use.uid }" type="text" value="${use.uid }" readonly="readonly">
					</td>
					<td>
						<input class="use${use.uid }" type="text" value="${use.uname}" readonly="readonly">
					</td>
					<td>
						<input class="use${use.uid }" type="text" value="${use.upassword}" border="1px solid blue" readonly="readonly">
					</td>
					<td>
						<a href="javascript:;" onclick="deleteById(${use.uid })">删除</a>
						&nbsp; &nbsp;
						<a href="javascript:;" onclick="update(${use.uid })">修改</a>
					</td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script type="text/javascript">

</script>

</html>