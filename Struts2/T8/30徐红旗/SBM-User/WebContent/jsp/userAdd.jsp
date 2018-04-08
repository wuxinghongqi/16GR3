<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'userAdd.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="main">
		<div class="optitle clearfix"></div>
		<s:form id="fileForm" action="userlogin_fileUpload"
			enctype="multipart/form-data" method="post">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">用户姓名：</td>
						<td><s:textfield id="userName" name="user.userName"
								class="text" /></td>
					</tr>
					<tr>
						<td class="field">用户密码：</td>
						<td><s:password id="userPassword" name="user.userPassword"
								class="text" /></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><s:password id="userPassword2" name="user.userPassword"
								class="text" /></td>
					</tr>

					<tr>
						<td class="field">用户性别：</td>
						<td><s:select id="userSex" name="user.userSex"
								list="{'男','女' }" value='"男"' /></td>
					</tr>

					<tr>
						<td class="field">用户年龄：</td>
						<td><s:textfield id="userAge" name="user.userAge"
								class="text" /></td>
					</tr>
					<tr>
						<td class="field">用户电话：</td>
						<td><s:textfield id="telephone" name="user.telephone"
								class="text" /></td>
					</tr>
					<tr>
						<td class="field">用户地址：</td>
						<td><s:textarea id="address" name="user.address" class="text"
								cols="45" rows="5" /></td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>
						<td><s:radio id="type" name="user.type"
								list="#{1:'普通用户',0:'经理' }" value="1"></s:radio></td>
					</tr>
					<tr>
						<td class="field">用户头像：</td>
						<td><s:file name="userpic" id="pic" /></td>
					</tr>
					<tr>
						<td><s:submit value="添加" cssClass="input-button" /></td>
						<td><s:reset value="清空" cssClass="input-button" /></td>
					</tr>
				</table>
			</div>
		</s:form>
	</div>
</body>
</html>