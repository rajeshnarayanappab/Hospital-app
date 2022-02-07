<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create ORDER</title>
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
<%String id=request.getParameter("encounterid"); %>
<%@ include file="staff_navbar.jsp" %>
<form action="createmedorder" method="post">
ID: <input type="text" value="<%=id%>" name="encounterid" readonly="readonly">
Time:<input type="datetime-local" name="localDateTime">
Message: <textarea rows="5" cols="10" name="msg"></textarea>

<input type="submit" value="create order">
</form>



</body>
</html>