<%@page import="com.ty.dto.Item"%>
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
List<Item> items = (List<Item>)request.getAttribute("myItem");
%>

<%@ include file="staff_navbar.jsp" %>

<table border="3">
	<tr>
		<th>ID</th>
		<th>Cost</th>
		<th>Msg</th>
		<th>Name</th>
		<th>Qty</th>
	</tr>
	
	<%
		for(Item item : items) {
			%>
			
			<tr>
				<td><%=item.getId()%></td>
				<td><%=item.getCost() %></td>
				<td><%=item.getMsg()%></td>
				<td><%=item.getName()%></td>
				<td><%=item.getQty()%></td>
				</tr>
				<%} %>
				</table>
</body>
</html>