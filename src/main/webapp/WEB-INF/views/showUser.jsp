<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Specific User Page</title>
</head>
<body>

	<h1>Specific User Page</h1>
	<p>Name: ${user.username }</p>

	<form action="updateUser?${user.id} ">
		<input type="hidden" value="${user.username }" name="userId">
		<input type="submit" value="Update User" />
	</form>
</body>
</html>