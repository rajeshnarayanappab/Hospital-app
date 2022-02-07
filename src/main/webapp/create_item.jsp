<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Item</title>
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
<%String id=request.getParameter("orderid"); %>
<%@ include file="staff_navbar.jsp" %>
<form action="createitem" method="post">
ID: <input type="text" value="<%=id%>" name="orderid" readonly="readonly">
Message:<input type="text" name="msg">
Cost:<input type="text" name="cost">
Quantity:<input type="text" name="qty">

<input type="submit" value="Give Item">
</form>
</body>
</html>