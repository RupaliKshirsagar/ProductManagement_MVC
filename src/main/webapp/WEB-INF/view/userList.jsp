<jsp:include page="menu.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<h3 style="color: red">${msg}</h3>
	<table style="margin-top: 20px" class="table table-dark">
		<thead>
			<tr>
				<th scope="col">UserName</th>
				<th scope="col">Gender</th>
				<th scope="col">Role</th>
				
				

				<%
				String role = (String) session.getAttribute("userRole");
				if (role.equals("Admin")) {
				%>
				<th scope="col">Password</th>
				<th scope="col">Question</th>
				<th scope="col">Answer</th>
				<th scope="col">Action</th>


				<%
				}
				%>
				<th scope="col">isActive</th>


			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="users">
				<tr>
					<td><c:out value="${users.username}"></c:out></td>

					<td><c:out value="${users.gender}"></c:out></td>
					<td><c:out value="${users.role}"></c:out></td>
					


					<%
					 role = (String) session.getAttribute("userRole");
					if (role.equals("Admin")) {
					%>

					<td><c:out value="${users.password}"></c:out></td>
					<td><c:out value="${users.question}"></c:out></td>
					<td><c:out value="${users.answer}"></c:out></td>
					<td><a href="getProfile?username=${users.username}">Edit</a> <a
						href="deleteUser?username=${users.username}">Delete</a></td>


					<%
					}
					%>

					
				</tr>

			</c:forEach>
		</tbody>
	</table>

</body>
</html>