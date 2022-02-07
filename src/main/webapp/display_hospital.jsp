<%@page import="com.ty.dto.Hospital"%>
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
List<Hospital> hospitals = (List<Hospital>)request.getAttribute("myHospital");
%>
<table border="3">
	<tr>
		<th>ID</th>
		<th>Gst</th>
		<th>Wesite</th>
		<th>Name</th>
		<th>Branch</th>
		<th>ViewBranch</th> 
	</tr>
	
	<%
		for(Hospital hospital : hospitals) {
			%>
			
			<tr>
				<td><%=hospital.getId()%></td>
				<td><%=hospital.getGst() %></td>
				<td><%=hospital.getWebsite()%></td>
				<td><%=hospital.getName() %></td>
				<td>
					<a href="create_branch.jsp?hospitalid=<%=hospital.getId()%>">AddBranch</a>
				</td>
			<td>
					<a href="displaybranch">ViewBranch</a>
				</td>
			</tr>
	<%
		}
	%>
</body>
</html>