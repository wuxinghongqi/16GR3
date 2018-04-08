<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.wrap{
	text-align: center;
	margin: 0 auto;
}
table{
	width: 75%;
}
</style>
</head>
<body>
	<a href="jsp/addUser.jsp">添加用户</a>
	<div class="wrap">
		<h2>用户列表</h2>
		<table border="1px">
			<tr>
				<td>用户ID</td>
				<td>用户姓名</td>
				<td>用户密码</td>
				<td>用户生日</td>
				<td>用户性别</td>
				<td>是否启用</td>
				<td>操作</td>
			</tr>
			<s:iterator value="users" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.uname }</td>
					<td>${user.upwd }</td>
					<td>${user.birthday }</td>
					<td>
						<s:if test='#user.sex == "M"'>
							男
						</s:if>
						<s:else>
							女
						</s:else>
					</td>
					<td>
						<s:if test="#user.enable == 1">
							是
						</s:if>
						<s:else>
							否
						</s:else>
					</td>
					<td>
						<!-- 
						1，先查询当前用户信息，参数id
						2,进入修改页面并设置用户信息
						3,修改提交
						 -->
						<a href="toUpdateUser?user.id=${user.id }">修改</a>
						<!-- 
						1，进入删除的业务，并且传递参数id
						2，删除成功之后，请求用户列表数据
						注意:使用user封装参数数据时，传递参数时必须使用user.id这种格式
						 -->
						<a href="deleteUser?user.id=${user.id }">删除</a>
					</td>
				</tr>
			</s:iterator>
		</table>
	                                                                                                                                                                                                                                                                                                                                                                6</div>
</body>
</html>