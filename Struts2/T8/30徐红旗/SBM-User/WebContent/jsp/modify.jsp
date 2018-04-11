<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'modify.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="menu">
		<form method="get" action="">
			商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
			是否付款：<select name="payStatus">
				<option value="">请选择</option>
				<option value="1">已付款</option>
				<option value="0">未付款</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="submit"
				value="组合查询" class="button" />
		</form>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<form method="post">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">账单编号：</td>
						<td><input type="text" name="billNum" class="text" /></td>
					</tr>
					<tr>
						<td class="field">交易金额：</td>
						<td><input type="text" name="money" class="text" /></td>
					</tr>
					<tr>
						<td class="field">商品描述：</td>
						<td><textarea name="discription"></textarea></td>
					</tr>
					<tr>
						<td class="field">是否付款：</td>
						<td><select name="isPay">
								<option value="1">是</option>
								<option value="2">否</option>
						</select></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" name="submit" value="确认" class="input-button" />
				<input type="button" name="button" value="返回" class="input-button"
					onclick="history.back();" />
			</div>
		</form>
	</div>
</body>
</html>