<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.yocaly.ssm.model.SysProModel,com.yocaly.ssm.controller.LoginController"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	Map<String, List<SysProModel>> tempMap = new HashMap<String, List<SysProModel>>();
	tempMap = LoginController.getTempMap();
	//System.out.println(tempMap.size());
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>组织机构编码</th>
			<th>主名称/IP</th>
			<th>驱动盘名称</th>
			<th>总空间大小</th>
			<th>可用空间大小</th>
			<th>检查时间</th>
			
			<th>提醒</th>
		</tr>
		<%
			if (tempMap != null && tempMap.size() > 0) {
				for (List<SysProModel> list : tempMap.values()) {
					for (SysProModel temp : list) {
						String str1 = temp.getOrgCode();
						String str2 = temp.getName();
						String str3 = temp.getDriver();
						int t = temp.getTotal();
						int f = temp.getFree();
						String str4 = temp.getUpdatetime();
		%>
		<tr>
			<td><%=str1%></td>
			<td><%=str2%></td>
			<td><%=str3%></td>
			<td><%=t%> G</td>
			<td><%=f%> G</td>
			<td><%=str4%></td>
			<td <%if (f < 10) {%> style="background: yellow" <%}%>><%=f < 10 ? "不足" : "充足"%></td>
		</tr>

		<%
			}
				}
			}
		%>
	</table>
</body>
</html>