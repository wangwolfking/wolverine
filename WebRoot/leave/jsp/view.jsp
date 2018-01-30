<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1.获取到规则流程图 这里是用的strust2的标签得到上面上面放入值栈的值-->
<img style="position: absolute;top: 0px;left: 0px;" src="viewImage.action?deploymentId=${deploymentId }&imageName=${imageName }">

<!-- 2.根据当前活动的坐标，动态绘制DIV -->
<div style="position: absolute;border:1px solid red;top:${acs.y}px;left: ${acs.x}px;width: ${acs.width}px;height:${acs.height}px;"></div>
</body>
</html>