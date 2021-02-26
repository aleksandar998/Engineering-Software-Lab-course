<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
</head>
<body>

<nav>
	<a href="create-user.jsp">Create user</a>
	<a href="show-users">List users</a>
	<a href="logout">Logout</a>

	Current user: ${user.name}
</nav>
<main>
	<h1>Welcome!</h1>
</main>

</body>
</html>