<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录 - 超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body class="blue-style">
	<div id="login">
		<div class="icon"></div>
		<div class="login-box">
			<s:form id="formLogin" action="userlogin_login" namespace="/" method="post">
				<dl>
					<dt>用户名：</dt>
					<dd><s:textfield id="userName" name="user.userName" class="input-text" /></dd>
					<dt>密 码：</dt>
					<dd><s:password id="userPassword" name="user.userPassword" class="input-text"/></dd>
				</dl>
				<div class="buttons">
					<input type="button" value="登录系统" class="input-button" onclick="loginCheck();" /> 
					<input type="reset" value="重　　填" class="input-button" />
				</div>
			</s:form>
		</div>
	</div>
	<s:fielderror name="EXP"/>
	<script type="text/javascript">
		function loginCheck() {
			var formLogin = document.getElementById("formLogin");
			var userName = document.getElementById("userName").value;
			var userPassword = document.getElementById("userPassword").value;
			if(userName !=null && userName != ""
					&& userPassword != null && userPassword != ""){
				formLogin.submit();
			}else{
				alert("用户名或密码不能为空!");
			}
		}
	</script>
</body>
</html>
