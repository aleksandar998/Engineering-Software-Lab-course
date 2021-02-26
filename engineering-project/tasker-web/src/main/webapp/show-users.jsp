<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<div>

    <table>
        <tr>
            <th>Name</th>
            <th>Username</th>
        </tr>


        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.name}</td>
                <td>${ user.username}</td>
            </tr>
        </c:forEach>


    </table>

</div>

</body>
</html>