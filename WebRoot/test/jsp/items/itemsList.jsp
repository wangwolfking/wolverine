<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品查询列表</title>
</head>
<body>
<form action="queryItems.action" method="post" title="qqqqq" enctype="application/x-www-form-urlencoded">

<input type="submit" value="123"></form>
	<table with="100%" border="1">
		<tr>
			<td>名称</td>
			<td>售价</td>
			<td>描述</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${itemsList}" var="item">
			<tr>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.detail}</td>
				<td><a href="#">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>