<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<%
		if (session.getAttribute("username") != null){
			response.sendRedirect("index.jsp");
		}
	%>
	Welcome ${username}
	<form action="/LogoutServlet" method="get">
		<input type="submit" value="Logout">
	</form>
</body>
</html>