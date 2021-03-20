<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Contact Person add</title>
</head>
<body>
<p>This is page for CONTACT PERSON ADD.</p>

<c:if test="${not empty information}">
    <div>${information}</div>
</c:if>

<c:if test="${not empty exception}">
    <div>${exception}</div>
</c:if>

<%--@elvariable id="contactPersonDto" type="it.engineering.spring.mvc.ds.dto.ContactPersonDto"--%>
<form:form action="${pageContext.request.contextPath}/contact_person/add" modelAttribute="contactPersonDto" method="post">
    <div>Contact person id:</div>
    <div>
        <form:input type="text" path="id" />
    </div>
    <div>
        <form:errors path="id" />
    </div>

    <div>Contact person firstname:</div>
    <div>
        <form:input type="text" path="firstname" />
    </div>
    <div>
        <form:errors path="firstname" />
    </div>

    <div>Contact person lastname:</div>
    <div>
        <form:input type="text" path="lastname" />
    </div>
    <div>
        <form:errors path="lastname" />
    </div>

    <div>Manufacturer:</div>
    <div>
        <form:select path="manufacturerDto" multiple="false">
            <form:options items="${manufacturers}" itemValue="id" itemLabel="name" />
        </form:select>
    </div>
    <div>
        <form:errors path="manufacturerDto" />
    </div>

    <button id="save">Save</button>

</form:form>
</body>
</html>