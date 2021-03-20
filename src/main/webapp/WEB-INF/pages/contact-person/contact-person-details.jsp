<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<p>This is page for CONTACT PERSON DETAILS...</p>

<c:if test="${not empty information}">
    <div>${information}</div>
</c:if>
<c:if test="${not empty exception}">
    <div>${exception}</div>
</c:if>

<%--@elvariable id="contactPersonDto" type="it.engineering.spring.mvc.ds.dto.ContactPersonDto"--%>
<form:form modelAttribute="contactPersonDto">
    <div>First name:</div>
    <div>
        <form:input type="text" path="firstname" size="60" readonly="true" />
    </div>
    <div>
        <form:errors path="firstname" />
    </div>

    <div>Last name:</div>
    <div>
        <form:input type="text" path="lastname" size="60" readonly="true" />
    </div>
    <div>Manufacturer name:</div>
    <div>
        <form:input type="text" path="manufacturerDto.name" size="60" readonly="true" />
    </div>
    <div>
        <form:errors path="manufacturerDto" />
    </div>

    <div>
        <a href="${pageContext.request.contextPath}/contact_person/edit/id/${contactPersonDto.id}">Edit</a>
    </div>
</form:form>

<form:form action="${pageContext.request.contextPath}/contact_person/delete/${contactPersonDto.id}"
           modelAttribute="contactPersonDto" method = "POST">
    <button>Delete</button>
</form:form>

</body>
</html>