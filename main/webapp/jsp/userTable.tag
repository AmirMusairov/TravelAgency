<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="users" type="java.util.list" required="true" %>

<style>
table, td, tr {
	border-radius: 2px;
	border: 1px solid black;
}
</style>


<table align="center">
	<tr>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Email</td>
		<td>Phone</td>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.firstName}</td>
			<td>${user.lastName}</td>
			<td>${user.email}</td>
			<td>${user.phone}</td>
		</tr>
	</c:forEach>
</table>