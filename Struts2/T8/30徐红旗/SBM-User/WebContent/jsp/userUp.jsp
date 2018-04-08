<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>用户修改</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<s:form action="userlogin_uptUser" id="upAForm" method="post"
			enctype="multipart/form-data">
			<div class="content">
				<s:hidden name="user.userId"/>
				<table class="box">
					<tr>
						<td class="field">用户名称：</td>
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
						<td><s:password id="userPassword2" class="text" /></td>
					</tr>

					<tr>
						<td class="field">用户性别：</td>
						<td><s:select id="userSex" name="user.userSex"
								list="{'男','女' }" value="user.userSex" /></td>
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
								list="#{1:'普通用户',0:'经理' }" value="user.type"></s:radio></td>
					</tr>
					<tr>
						<td class="field">用户头像：</td>
						<td><s:file name="userpic" id="pic" /></td>
					</tr>
					<tr>
						<td><s:submit value="确认修改" cssClass="input-button"/></td>
						<td><s:reset value="清空" cssClass="input-button" /></td>
					</tr>
				</table>
			</div>
		</s:form>
		<s:fielderror/>
	</div>
</body>
</html>