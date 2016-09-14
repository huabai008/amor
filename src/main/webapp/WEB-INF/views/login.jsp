<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
login
<form action="auth/login" method="post">
	<label>用户名</label>
	<input id="username" name="username" />
	<label>密码</label>
	<input id="password" name="password" type="password"/>
	<button type="submit">登录</button>
</form>
</body>
</html>