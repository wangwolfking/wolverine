<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend>登录页面</legend>
<form action="${pageContext.request.contextPath}/login.action" method="post">
<label>用户名:</label> <input name="username" id = "username" type="text"/> <input type="submit" value="登录"/><br>
<%--<a href="${pageContext.request.contextPath}/login1.action">请假</a>
<a href="${pageContext.request.contextPath}/login2.action">12345</a>
<a href="${pageContext.request.contextPath}/login/jsp/index.jsp">666</a>--%>
</form>
</fieldset>
</body>
</html>