<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="users" type="java.util.list" required="true"%>

<style>
table, td, tr {
	border-radius: 2px;
	border: 1px solid black;
}
</style>


<table style="align: center;">
	<tr>
		<td>Name</td>
		<td>Password</td>
		<td>Email</td>
		<td>Birthday</td>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td>${user.email}</td>
			<td>${user.birthday}</td>
		</tr>
	</c:forEach>
</table>