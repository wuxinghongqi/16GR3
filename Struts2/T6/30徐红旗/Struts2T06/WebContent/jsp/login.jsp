<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<s:form action="login_User" method="post">
<s:textfield key="lable.uname" name="user.uname" required="true"></s:textfield>
<br>
<s:password key="lable.password" name="user.upwd" required="true"></s:password>
<s:submit key="lable.login"></s:submit>
</s:form>
</body>
</html>