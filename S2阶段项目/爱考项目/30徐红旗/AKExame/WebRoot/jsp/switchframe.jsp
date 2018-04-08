<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'switchframe.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>显示/隐藏左侧导航栏</title>
</head>

<script language="JavaScript">
    function Submit_onclick() {
        if (parent.myFrame.cols == "199,7,*") {
            parent.myFrame.cols = "0,7,*";
            document.getElementById("ImgArrow").src = "images/switch_right.gif";
            document.getElementById("ImgArrow").alt = "打开左侧导航栏";
        } else {
            parent.myFrame.cols = "199,7,*";
            document.getElementById("ImgArrow").src = "images/switch_left.gif";
            document.getElementById("ImgArrow").alt = "隐藏左侧导航栏";
        }
    }

</script>

<body>
	<div id="switchpic">
		<a href="javascript:Submit_onclick()"> <img
			src="images/switch_left.gif" alt="隐藏左侧导航栏" id="ImgArrow" /></a>
	</div>
</body>
</html>
