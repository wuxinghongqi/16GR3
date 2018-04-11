<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Llogin" method="post">
<table>
<tr>
	<td>姓名：</td>
	<td><input type="text" name="nam"/></td>
</tr>
<tr>
	<td>密码：</td>
	<td><input type="password" name="pwd"/></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="登录"/></td>
</tr>
</table>
</form>

<p style="color: red;">${Info }</p>
</body>
</html>