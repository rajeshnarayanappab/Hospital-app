<%@page import="com.ty.dto.Encounter"%>
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
List<Encounter> encounters = (List<Encounter>)request.getAttribute("myEncounter");
%>

<%@ include file="staff_navbar.jsp" %>

<table border="3">
	<tr>
		<th>ID</th>
				<th>CreatedDateTime</th>
		<th>CreatorName</th>
		<th>Reason</th>
		<th>Order</th>
			<th>OrderView</th>
	</tr>
	
	<%
		for(Encounter encounter : encounters) {
			%>
			
			<tr>
				<td><%=encounter.getId()%></td>
				<td><%=encounter.getCreatedDateTime() %></td>
				<td><%=encounter.getCreatorName() %></td>
				<td><%=encounter.getReason() %></td>
				<td>
					<a href="create_medorder.jsp?encounterid=<%=encounter.getId()%>">PlaceOrder</a>
				</td>
				<td>
					<a href="displaymedorder">ViewMedorder</a>
				</td>
			</tr>
	<%
		}
	%>
	
		
</table>
</body>
</html>