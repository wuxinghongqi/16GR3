<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
上传者: ${username } <br />
文件名: ${uploadFileFileName } <br />
文件类型:　${uploadFileContentType } <br />

**********************************************
<br />
<a href="/T7/upload/${uploadFileFileName }">${uploadFileFileName }</a>

</body>
</html>