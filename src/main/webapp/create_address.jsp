<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Address</title>
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
<%String id=request.getParameter("branchid"); %>

<form action="createaddress" method="post">
<table>

<thead>
<h1>CREATE ADDRESS</h1></thead>

<tr>
ID: <input type="text" value="<%=id%>" name="branchid" readonly="readonly">

<td>
<label for="city_name">Address:</label>
</td>
<td><input type="text" id="city_name" name="city_name"></td>
</tr>

<tr>
<td><label for="state">State:</label></td>
<td><input type="text" id="state" name="state"></td>
</tr>

<tr>
<td><label for="pin"> Pincode:</label></td>
<td><input type="number" id="pin" name="pincode"></td>
</tr>




<tr>
<td colspan="2" align="center"> <input type="submit" value="Done"> </td>
</tr>

</table>

</form>



</body>
</html>