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
		<legend>申请表</legend>
		<form action="${pageContext.request.contextPath}/leaveSubmit.action"
			method="post">
			<input type="hidden" name="taskid" value="${taskid}"> <input
				type="hidden" name="processInstanceId" value="${processInstanceId}">
			<table>
				<tr>
					<td>申请人：</td>
					<td><input type="text" name="owner"
						value="${sessionScope['username']}" /></td>
				</tr>
				<tr>
					<td>请假时间：</td>
					<td><input type="text" name="day" value="" /></td>
				</tr>
				<tr>
					<td>请假原因：</td>
					<td><textarea name="reason"></textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交申请" /></td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>