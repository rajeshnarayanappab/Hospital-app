<%@page import="com.ty.dto.Branch"%>
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
List<Branch> branchs = (List<Branch>)request.getAttribute("myBranch");
%>
<table border="3">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Contact</th>
		<th>Email</th>
	<th>Address</th>
	<th>ViewAddress</th>
	</tr>
	
	<%
		for(Branch branch : branchs) {
			%>
			
			<tr>
				<td><%=branch.getId()%></td>
				<td><%=branch.getName() %></td>
				<td><%=branch.getCno()%></td>
				<td><%=branch.getEmail() %></td>
				<td>
					<a href="create_address.jsp?branchid=<%=branch.getId()%>">CreateAddress</a>
				</td>
							<td>	<a href="displayaddress">ViewAddress</a></td>
			
			</tr>
	<%
		}
	%>
</body>
</html>