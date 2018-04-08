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
<s:form action="user" method="post">
	<s:textfield label="用户名" name="user.uname" required="true"></s:textfield>
	<s:password label="密码" name="user.upwd" required="true"></s:password>
	<s:checkboxlist label="爱好" list="{'吃','喝','玩','乐'}" name="user.like"></s:checkboxlist>
	<s:select label="学历" list="{'初中','高中','大专','本科','研究生'}" size="1" value="'大专'" name="user.educat"></s:select>
	<s:radio label="性别" list="#{1:'男',0:'女' }" name="user.sex" value="0"></s:radio>
	<s:submit value="注册"></s:submit>
</s:form>

</body>
</html>