<%@ taglib prefix="custom" tagdir="/webapp/jsp/custom"%>
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
		<c:if test="${loggedInUser.role == 3}">
			<button align="center">Destroy your pussy</button>
		</c:if>
	</div>

	<custom:footer />






</body>
</html>
