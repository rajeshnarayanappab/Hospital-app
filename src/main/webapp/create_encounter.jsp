<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Encounter</title>
<style>
table, th, td,h1{
padding: 30px;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
}
</style>

</head>
<body>
<%String id=request.getParameter("personId"); 
%>
<%@ include file="staff_navbar.jsp" %>
<form action="createencounter" method="post">
ID: <input type="text" value="<%=id%>" name="personId" readonly="readonly">
Admit:<input type="datetime-local" name="localDateTime">
Reason: <textarea rows="10" cols="20" name="reason"></textarea>

<input type="submit" value="create encounter">
</form>




</body>
</html>