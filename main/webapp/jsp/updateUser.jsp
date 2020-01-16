<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, td, tr {
    border-radius: 2px;
    border: 1px solid black;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="table">
	<form>
		<input type="hidden" value="${user.firstName}" name="userId"/>
		<table>
		<caption>Users</caption>
			<tr>
				<td>Name:</td>
				<td><input type="text" value="${user.firstName}" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" value="${user.lastName}" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" value="${user.email}" /></td>
			</tr>
			<tr>
				<td>Login:</td>
				<td><input type="text" value="${user.login}" /></td>
			</tr>
			<tr>
				<td>phone:</td>
				<td><input type="text" value="${user.phone}" /></td>
			</tr>
			<tr>
				<td>Role:</td>
				<td><input type="text" value="${user.role}" /></td>
			</tr>
			<tr>
				<td rowspan="2" align="center"><input  type="submit" value="update"/></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>