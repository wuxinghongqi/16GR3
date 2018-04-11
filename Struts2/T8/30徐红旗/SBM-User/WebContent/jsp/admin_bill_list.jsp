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

<title>My JSP 'admin_bill_list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="menu">
		<form method="post" action="account?cmd">
			商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
			是否付款：<select name="isPayed">
				<option value="">请选择</option>
				<option value="1">已付款</option>
				<option value="0">未付款</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="submit"
				value="组合查询" class="button" />
		</form>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input type="button" name="button" value="添加数据"
				class="input-button" onclick="location.href='jsp/modify.jsp'" /></em>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tr>
					<td>账单编号</td>
					<td>商品名称</td>
					<td>商品数量</td>
					<td>交易金额</td>
					<td>是否付款</td>
					<td>供应商名称</td>
					<td>商品描述</td>
					<td>账单时间</td>
				</tr>
				<c:forEach items="${pageBean.data }" var="accountDetail">
					<tr>
						<td>${accountDetail.accountId }</td>
						<td>${accountDetail.goodsName }</td>
						<td>${accountDetail.goodsNum }</td>
						<td>${accountDetail.totalPrice }</td>
						<td>
						<c:if test="${accountDetail.isPayed == 1}">
							已付款
						</c:if>
						<c:if test="${accountDetail.isPayed == 0}">
							未付款
						</c:if>
						</td>
						<td>${accountDetail.providerName }</td>
						<td>${accountDetail.goodsIntro }</td>
						<td>${accountDetail.accountDate }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<form id="form" action="account?cmd=getPageBean">
		<label class="input-button">跳转到</label>
    	<select name="p" onchange="getPageBeanByP();">
    		<c:forEach var="j" begin="1" end="${pageBean.getPagetotal()}">
    			<c:if test="${pageBean.getP() == j}">
    				<option selected="selected" value="${j}">第${j}页</option>
    			</c:if>
    			<c:if test="${pageBean.getP() != j}">
    				<option value="${j}">第${j}页</option>
    			</c:if>
    		</c:forEach>
    	</select>
    </form>
    
    <a class="input-button" href="account?cmd=getPageBean&p=${pageBean.p - 1 }">上一页</a>
    <a class="input-button" href="account?cmd=getPageBean&p=${pageBean.p + 1 }">下一页</a>
	</div>
	<script type="text/javascript">
		function getPageBeanByP() {
			var form = document.getElementById("form");
			form.submit();
		}
	</script>
</body>
</html>