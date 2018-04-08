<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'home.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>在线考试管理系统</title>
</head>
<frameset rows="50,*" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="jsp/top.jsp" name="topFrame" frameborder="no" scrolling="No"
		noresize="noresize" id="topFrame" title="topFrame" />
	<frameset name="myFrame" cols="199,7,*," frameborder="no" border="0"
		framespacing="0">
		<frame src="jsp/left.jsp" name="leftFrame" frameborder="no" scrolling="No"
			noresize="noresize" id="leftFrame" title="leftFrame" />
		<frame src="jsp/switchframe.jsp" name="midFrame" frameborder="no"
			scrolling="No" noresize="noresize" id="midFrame" title="midFrame" />
		<frameset rows="59,*" cols="*" frameborder="no" border="0"
			framespacing="0">
			<frame src="jsp/mainframe.jsp" name="mainFrame" frameborder="no"
				scrolling="No" noresize="noresize" id="mainFrame" title="mainFrame" />
			<frame src="jsp/manframe.jsp" name="manFrame" frameborder="no"
				id="manFrame" title="manFrame" />
		</frameset>
	</frameset>
</frameset>
</html>