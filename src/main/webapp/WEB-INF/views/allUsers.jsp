<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags/custom"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, td, tr {
	border-radius: 2px;
	border: 1px solid black;
}

.destroy_button {
	margin-top: 10px;
}
</style>
<meta charset="ISO-8859-1">
<title>All Users</title>
</head>
<body>


	<custom:userTable users="${users}" />
	<div class="destroy_button" align="center">
		<c:if test="${loggedInUser.role == 2}">
			<button style="align: center;">Destroy your brain</button>
		</c:if>
	</div>

	<custom:footer />






</body>
</html>