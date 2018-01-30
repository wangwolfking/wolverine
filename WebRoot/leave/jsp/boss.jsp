<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function aa(param_tag) {
		document.getElementById("result").value = param_tag;
		document.getElementById("bossForm").submit();

	}
</script>
</head>
<body>
	<fieldset>
		<legend>老板审核</legend>
		<form id="bossForm" name="bossForm"
			action="${pageContext.request.contextPath}/leaveBoss.action"
			method="post">
			<input type="hidden" name="taskid" value="${taskid}"> <input
				type="hidden" id="result" name="result" value=""> <input
				type="hidden" name="processInstanceId" value="${processInstanceId}">
			<table>
				<tr>
					<td>申请人：</td>
					<td><input name="owner" value='<c:out value="${owner }"/>'
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>请假时间：</td>
					<td><input name="day" value='<c:out value="${day }"/>'
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>请假原因：</td>
					<td><input name="reason" value='<c:out value="${reason }"/>'
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>经理意见：</td>
					<td><textarea name="reasonManager" readonly="readonly"><c:out
								value="${reasonManager }"></c:out></textarea></td>
				</tr>
				<tr>
					<td><input type="button" onclick="javascript:aa('agree')"
						value="同意" /></td>
					<td><input type="button" onclick="javascript:aa('bossOppose')"
						value="驳回" /></td>
				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>