<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'userAdmin.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><s:form method="post" action="userlogin_getUserByInfo">
						用户名称：
							<s:textfield name="user.userName" class="input-text" />
							&nbsp;&nbsp;&nbsp;&nbsp;
							<s:submit value="查询" />
						</s:form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加用户" class="input-button"
				onclick="window.location='jsp/userAdd.jsp'" type="button"></em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="50"><div class="STYLE1" align="center">头像</div></td>
						<td width="80"><div class="STYLE1" align="center">用户名称</div></td>
						<td width="100"><div class="STYLE1" align="center">性别</div></td>
						<td width="100"><div class="STYLE1" align="center">年龄</div></td>
						<td width="150"><div class="STYLE1" align="center">电话</div></td>
						<td width="150"><div class="STYLE1" align="center">地址</div></td>
						<td width="150"><div class="STYLE1" align="center">权限</div></td>
						<td width="150"><div class="STYLE1" align="center">操作</div></td>
					</tr>
					<s:iterator value="userlist" var="uuser">
						<tr>
							<td height="23"><span class="STYLE1">${uuser.userId }</span></td>
							<td><span class="STYLE1"><img alt="photo"
									src="${uuser.pic }" width="50px" height="45px"></span></td>
							<td><span class="STYLE1">${uuser.userName }</span></td>
							<td><span class="STYLE1"><s:if
										test='#uuser.userSex =="男"'>男</s:if> <s:else>女</s:else></span></td>
							<td><span class="STYLE1">${uuser.userAge }</span></td>
							<td><span class="STYLE1">${uuser.telephone }</span></td>
							<td><span class="STYLE1">${uuser.address }</span></td>
							<td><span class="STYLE1">&nbsp;<s:if
										test='#uuser.type =="1"'>普通职员</s:if> <s:else>经理</s:else></span></td>
							<td><span class="STYLE1"><a
									href="userlogin_getUserById?user.userId=${uuser.userId }">修改</a>&emsp;<a
									href="userlogin_delUser?user.userId=${uuser.userId }">删除</a></span></td>
						</tr>
					</s:iterator>
					<s:fielderror />
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
