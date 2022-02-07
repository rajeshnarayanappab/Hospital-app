<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Person</title>

<style>
table, th, td {
  border-collapse: collapse;
}
th, td {
  padding: 15px;
}
</style>



</head>
<body>

<%@ include file="person_navbar.jsp" %>


<form action="createperson" method="post">
<table>

<thead>
<h1>CREATE PERSON</h1></thead>

<tr>
<td>
<label for="name">Name:</label>
</td>
<td><input type="text" id="name" name="name"></td>
</tr>

<tr>
<td><label for="email">Email:</label></td>
<td><input type="email" id="email" name="email"></td>
</tr>

<tr>
<td><label for="cno">Contact Number:</label></td>
<td><input type="number" id="cno" name="cno"></td>
</tr>


<tr>
<td><label for="age"> Age:</label></td>
<td><input type="number" id="age" name="age"></td>
</tr>


<tr>
<td><label>Gender:</label></td>
<td><input type="radio" name="gender" value="Male">Male
<input type="radio" name="gender" value="Female">Female</td>
</tr>


<tr>
<td><label for="id"> Encounter Id:</label></td>
<td><input type="number" id="id" name="encounterId"></td>
</tr>

<tr>
<td colspan="2" align="center"> <input type="submit" value="Done"> </td>
</tr>

</table>

</form>



</body>
</html>