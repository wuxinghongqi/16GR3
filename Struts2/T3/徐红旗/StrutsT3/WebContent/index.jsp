<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="user" method="post">
	用户名:<input type="text" name="user.uname"/><br/>
	密码:<input type="password" name="user.upwd"/><br/>
	年龄:<input type="text" name="user.age"/><br/>
	生日:<input type="text" name="user.birthday"/><br/>
	性别:<input type="text" name="user.sex"/><br/>
	地址:<input type="text" name="user.address"/><br/>
	手机号:<input type="text" name="user.telphone"/><br/>
	<input type="submit" value="注册"/>
</form>
</body>
</html>