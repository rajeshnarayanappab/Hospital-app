<%@page import="com.ty.dto.MedOrder"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<MedOrder> medorders = (List<MedOrder>)request.getAttribute("myMedorder");
%>

<%@ include file="staff_navbar.jsp" %>

<table border="3">
	<tr>
		<th>ID</th>
		<th>CreatedDateTime</th>
		<th>CreatorName</th>
		<th>Message</th>
		<th>Item</th>
		<th>ViewItem</th>
	</tr>
	
	<%
		for(MedOrder medorder : medorders) {
			%>
			
			<tr>
				<td><%=medorder.getId()%></td>
				<td><%=medorder.getCreatedDateTime()%></td>
				<td><%=medorder.getCreatorName()%></td>
				<td><%=medorder.getMsg()%></td>
				<td>
					<a href="create_item.jsp?orderid=<%=medorder.getId()%>">Item</a>
				</td>
					<td>
					<a href="displayitem">ViewItem</a>
				</td>
				</tr>
				<%} %>
				</table>
</body>
</html>