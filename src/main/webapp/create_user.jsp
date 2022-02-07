<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create User</title>
<style>
table, th, td, h1 {
	padding: 30px;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
}
</style>

</head>
<body>

	<form action="#" method="post">
		<table>

			<thead>
				<h1>CREATE USER</h1>
			</thead>

			<tr>
				<td><label for="name">Name:</label></td>
				<td><input type="text" id="name" name="name"></td>
			</tr>


			<tr>
				<td><label for="email">Email:</label></td>
				<td><input type="email" id="email" name="email"></td>
			</tr>

			<tr>
				<td><label for="pwd">Password:</label></td>
				<td><input type="password" id="pwd" name="password"></td>
			</tr>


			<tr>
				<td><label for="phno">Contact Number:</label></td>
				<td><input type="number" id="phno" name="phoneNo"></td>
			</tr>



			<tr>
				<td><label>Role:</label></td>
				<td><input type="radio" name="role" value="Person">Person
					<input type="radio" name="role" value="Admin">Admin
				<input type="radio" name="role" value="Staff">Staff</td>
			</tr>


			<tr>
				<td><label for="bid"> Branch Id:</label></td>
				<td><input type="number" id="bid" name="branchId"></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Done"></td>
			</tr>

		</table>

	</form>



</body>
</html>