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
<table>
<thead>
<h1>CREATE  HOSPITAL</h1></thead>
<tr>
<br><br><br>
<form action="createhospital" method="post">
Website:<input type="text" name="website">
Name:<input type="text" name="name">
Gst:<input type="text" name="gst">
<input type="submit" value="create hospital">
</form>


</table>

</form>



</body>
</html>