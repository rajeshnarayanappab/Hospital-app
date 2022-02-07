<%@page import="com.ty.dto.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Item</title>
</head>
<body>


<%
List<Person> persons = (List<Person>)request.getAttribute("myPerson");
%>

<%@ include file="staff_navbar.jsp" %>

<table border="3">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Phone</th>
		<th>Email</th>
		<th>Age</th>
		<th>Gender</th>
		<th>View</th>	
		<th>Create</th>
		<th>Create Encounter</th>
		<th>ViewEncounter</th>
	</tr>
	
	<%
		for(Person person : persons) {
			%>
			
			<tr>
				<td><%=person.getId() %></td>
				<td><%=person.getName() %></td>
				<td><%=person.getEmail() %></td>
				<td><%=person.getCno() %></td>
				<td><%=person.getAge() %></td>
				<td><%=person.getGender() %></td>
			<td>
					<a href="display">View</a>
				</td>
				<td>
					<a href="create_person.jsp">Create</a>
				</td>
					<td>
					<a href="create_encounter.jsp?personId=<%=person.getId()%>">CreateEncounter</a>
				</td>
				<td>
					<a href="displayencounter">ViewEncounter</a>
				</td>
			
			</tr>
			
	<%
		}
	%>
	
		
</table>
</form>

</body>
</html>