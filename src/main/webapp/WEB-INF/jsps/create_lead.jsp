<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create</title>
</head>
<body>
	<h2>Create | Lead</h2>
	<form action="saveLead" method="post">
	<table>
	<tr><td>First Name </td><td><input type="text" name="firstName"/></td></tr>
	<tr><td>Last Name </td><td><input type="text" name="lastName"/></td></tr>
	<tr><td>Email </td><td><input type="email" name="email"/></td></tr>
	<tr><td>Mobile </td><td><input type="number" name="mobile"/></td></tr>
	<tr><td>Source: </td><td><select name="source">
		<option value="news paper">News Paper</option>
		<option value="tv commercial">TV Commercial</option>
		<option value="online">Online</option>
		<option value="seminar">Seminar</option>
	</select></td></tr>
	<tr></tr>
	<tr><td style="text-align:center" colspan="2"><input type="submit" value="save"/></td></tr>
	</table>
	</form>
</body>
</html>