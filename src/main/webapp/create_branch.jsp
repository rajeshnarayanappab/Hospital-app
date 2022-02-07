<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Hospital</title>
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
<%String id=request.getParameter("hospitalid"); %>

<table>
<thead>
<h1>CREATE  Branch</h1></thead>
<tr>
<br><br><br>

<form action="createbranch" method="post">
ID: <input type="text" value="<%=id%>" name="hospitalid" readonly="readonly">
email:<input type="text" name="email">
Name:<input type="text" name="name">
phone:<input type="number" name="phone">


<input type="submit" value="create branch">
</form>


</table>

</form>



</body>
</html>