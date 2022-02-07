<%@page import="com.ty.dto.Address"%>
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
List<Address> addresses = (List<Address>)request.getAttribute("myAddress");
%>
<table border="3">
	<tr>
		<th>ID</th>
		<th>City</th>
		<th>State</th>
		<th>Pincode</th>
	</tr>
	
	<%
		for(Address address : addresses) {
			%>
			
			<tr>
				<td><%=address.getId()%></td>
				<td><%=address.getCity_name()%></td>
				<td><%=address.getState()%></td>
				<td><%=address.getPincode() %></td>
					</tr>
				<%} %>
				</table>
				</body>
</html>