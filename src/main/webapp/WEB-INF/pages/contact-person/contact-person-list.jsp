<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Manufactures</title>
</head>
<body>
This is page for CONTACT PERSONS list.
<div>
    <h1>All CONTACT PERSONS</h1>
    <table>
        <thead>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Manufacturer name</th>
            <th>Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${contactPersons}">
            <tr>
                <td>${c.firstname}</td>
                <td>${c.lastname}</td>
                <td>${c.manufacturerDto.name}</td>
                <td><a href="${pageContext.request.contextPath}/contact_person/details/id/${c.id}"> details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>