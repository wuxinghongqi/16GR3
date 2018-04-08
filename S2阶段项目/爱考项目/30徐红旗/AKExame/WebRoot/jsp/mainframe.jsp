<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'mainframe.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/common.css" type="text/css" />
    <title>管理导航区域</title>
</head>

<script type="text/javascript">
    var preClassName = "man_nav_1";
    function list_sub_nav(Id, sortname) {
        if (preClassName != "") {
            getObject(preClassName).className = "bg_image";
        }
        if (getObject(Id).className == "bg_image") {
            getObject(Id).className = "bg_image_onclick";
            preClassName = Id;
            window.top.frames['leftFrame'].outlookbar.getbytitle(sortname);
            window.top.frames['leftFrame'].outlookbar.getdefaultnav(sortname);
        }
    }

    //获取对象属性兼容方法
    function getObject(objectId) {
        if (document.getElementById && document.getElementById(objectId)) {
            // W3C DOM
            return document.getElementById(objectId);
        } else if (document.all && document.all(objectId)) {
            // MSIE 4 DOM
            return document.all(objectId);
        } else if (document.layers && document.layers[objectId]) {
            // NN 4 DOM.. note: this won't find nested layers
            return document.layers[objectId];
        } else {
            return false;
        }
    }
</script>

<body>
    <div id="nav">
        <ul>
            <li id="man_nav_2" class="bg_image_onclick">后台管理</li></ul>
    </div>
    <div id="sub_info">
        &nbsp;&nbsp;<img src="images/hi.gif" />&nbsp;<span id="show_text">欢迎使用在线考试管理系统!</span></div>
</body>
</html>