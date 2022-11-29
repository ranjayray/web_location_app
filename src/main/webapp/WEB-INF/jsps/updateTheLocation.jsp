<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Location</title>
</head>
<body>
	<h2>Update Location</h2>
	<form action="updateLocationData" method="post">
	Id<input type="text" name="id" value="${id}" readonly/>
	Code<input type="text" name="code" value="${code}"/>
	Name<input type="text" name="name" value="${name}"/>
	Type
	Urban:<input type="radio" name="type" value="urban"/>
	Rural:<input type="radio" name="type" value="rural"/>
	<input type="submit" value="update"/>
	</form>
	${updatedMsg}
</body>
</html>