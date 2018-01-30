<%@ page import="java.util.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请假流程主页</title>
</head>
<body>
	<a href="deployFlow.action">发布流程请假流程</a> username:<c:out value="${username }"></c:out> <a href="login/jsp/login.jsp">登录</a>
	<br><br><br>
	<fieldset>
		<legend>已发布的流程列表</legend>
	<table border="1"> 
		<c:if
			test="${processDefinitionList!=null && fun:length(processDefinitionList) > 0}">
			<tr>
				<th>流程id</th>
				<th>流程名称</th>
				<th>发布id</th>
				<th>Key</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${processDefinitionList}" var="pd">
				<tr>
					<td><c:out value="${pd.id }"></c:out></td>
					<td><c:out value="${pd.name }"></c:out></td>
					<td><c:out value="${pd.deploymentId }"></c:out></td>
					<td><c:out value="${pd.key }"></c:out></td>
					<td><a
						href="deleteFlow.action?deploymentId=${pd.deploymentId }">删除</a> <a
						href="startFlow.action?key=${pd.key }">我要请假</a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if
			test="${processDefinitionList==null || fun:length(processDefinitionList) <= 0}">
			<tr>
				<td>没有发布任何流程</td>
			</tr>
		</c:if>
	</table>
	</fieldset>
	<fieldset>
		<legend>流程实例列表</legend>
	<table border="1"> 
		<c:if
			test="${processInstanceList!=null && fun:length(processInstanceList) > 0}">
			<tr>
				<th>实例id</th>
				<th>实例名称</th>
				<th>businessKey</th>
				<th>processDefinitionKey</th>
				<th>操作</th>
				<th>删除</th>
			</tr>
			<c:forEach items="${processInstanceList}" var="pil">
				<tr>
					<td><c:out value="${pil.id }"></c:out></td>
					<td><c:out value="${pil.processDefinitionName }"></c:out></td>
					<td><c:out value="${pil.businessKey }"></c:out></td>
					<td><c:out value="${pil.processDefinitionKey }"></c:out></td>
					<td><a href="${pageContext.request.contextPath}/queryProPlan.action?processDefinitionid=${pil.processDefinitionId  }&ProcessInstanceId=${pil.id }">查看进程</a></td>
					<td><a href="${pageContext.request.contextPath}/deleteProcessInstance.action?processDefinitionid=${pil.id  }">删除请假实例</a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if
			test="${processInstanceList==null || fun:length(processInstanceList) <= 0}">
			<tr>
				<td>没有流程实例</td>
			</tr>
		</c:if>
	</table>
</fieldset>
<fieldset>
		<legend>我的已完成的任务列表</legend>
	<table border="1"> 
		<c:if
			test="${historicTaskList!=null && fun:length(historicTaskList) > 0}">
			<tr>
				<th>任务id</th>
				<th>任务名称</th>
				<th>创建时间</th>
				<th>流程实例id</th>
				<th>流程定义id</th>				
				<th>操作</th>
				<th>查看</th>
			</tr>
			<c:forEach items="${historicTaskList}" var="tl">
				<tr>
					<td><c:out value="${tl.id }"></c:out></td>
					<td><c:out value="${tl.name }"></c:out></td>
					<td><c:out value="${tl.createTime }"></c:out></td>
					<td><c:out value="${tl.processInstanceId }"></c:out></td>
					<td><c:out value="${tl.processDefinitionId }"></c:out></td>
					<td><a href="${pageContext.request.contextPath}/${tl.formKey }?taskid=${tl.id }&processInstanceId=${tl.processInstanceId }">请假</a></td>
					<td><a target="_blank" href="${pageContext.request.contextPath}/queryProPlan.action?processDefinitionid=${tl.processDefinitionId }&ProcessInstanceId=${tl.id }">view</a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if
			test="${historicTaskList==null || fun:length(historicTaskList) <= 0}">
			<tr>
				<td>没有已完成的任务</td>
			</tr>
		</c:if>
	</table>
	</fieldset>
<fieldset>
		<legend>我的未完成的任务列表</legend>
	<table border="1"> 
		<c:if
			test="${unhistoricTaskList!=null && fun:length(unhistoricTaskList) > 0}">
			<tr>
				<th>任务id</th>
				<th>任务名称</th>
				<th>创建时间</th>
				<th>流程实例id</th>
				<th>流程定义id</th>				
				<th>操作</th>
				<th>查看</th>
			</tr>
			<c:forEach items="${unhistoricTaskList}" var="tl">
				<tr>
					<td><c:out value="${tl.id }"></c:out></td>
					<td><c:out value="${tl.name }"></c:out></td>
					<td><c:out value="${tl.createTime }"></c:out></td>
					<td><c:out value="${tl.processInstanceId }"></c:out></td>
					<td><c:out value="${tl.processDefinitionId }"></c:out></td>
					<td><a href="${pageContext.request.contextPath}/${tl.formKey }?taskid=${tl.id }&processInstanceId=${tl.processInstanceId }">请假</a></td>
					<td><a target="_blank" href="${pageContext.request.contextPath}/queryProPlan.action?processDefinitionid=${tl.processDefinitionId }">view</a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if
			test="${unhistoricTaskList==null || fun:length(unhistoricTaskList) <= 0}">
			<tr>
				<td>没有未完成的任务</td>
			</tr>
		</c:if>
	</table>
	</fieldset>
<fieldset>
		<legend>我的任务列表</legend>
	<table border="1"> 
		<c:if
			test="${tasklist!=null && fun:length(tasklist) > 0}">
			<tr>
				<th>任务id</th>
				<th>任务名称</th>
				<th>创建时间</th>
				<th>流程实例id</th>
				<th>流程定义id</th>				
				<th>操作</th>
				<th>查看</th>
			</tr>
			<c:forEach items="${tasklist}" var="tl">
				<tr>
					<td><c:out value="${tl.id }"></c:out></td>
					<td><c:out value="${tl.name }"></c:out></td>
					<td><c:out value="${tl.createTime }"></c:out></td>
					<td><c:out value="${tl.processInstanceId }"></c:out></td>
					<td><c:out value="${tl.processDefinitionId }"></c:out></td>
					<td><a href="${pageContext.request.contextPath}/${tl.formKey }?taskid=${tl.id }&processInstanceId=${tl.processInstanceId }">填写请假单</a></td>
					<td><a target="_blank" href="${pageContext.request.contextPath}/viewCurrentImage.action?taskid=${tl.id }">view</a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if
			test="${tasklist==null || fun:length(tasklist) <= 0}">
			<tr>
				<td>没有待办任务</td>
			</tr>
		</c:if>
	</table>
	</fieldset>
</body>
</html>