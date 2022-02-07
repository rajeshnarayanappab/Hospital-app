<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

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



<form action="login" method="post">
<table>
<thead>
<h1>LOGIN PAGE</h1></thead>
<tr>
<td>
<label for="email">Email:</label>
</td>
<td><input type="email" id="email" name="email"></td>
</tr>

<tr>
<td><label for="pwd">Password:</label></td>
<td><input type="password" id="pwd" name="password"></td>
</tr>

<tr>
<td colspan="2" align="center"> <input type="submit" value="Login"> </td>
</tr>

</table>

</form>


</body>
</html>