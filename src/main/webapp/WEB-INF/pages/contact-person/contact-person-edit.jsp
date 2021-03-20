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
<p>This is page for CONTACT PERSON edit.</p>

<c:if test="${not empty information}">
    <div>${information}</div>
</c:if>

<c:if test="${not empty exception}">
    <div>${exception}</div>
</c:if>

<%--@elvariable id="contactPersonDto" type="it.engineering.spring.mvc.ds.dto.ContactPersonDto"--%>
<form:form action="${pageContext.request.contextPath}/contact_person/confirm" modelAttribute="contactPersonDto" method="post">

    <form:hidden path="id" />

    <div>First name:</div>
    <div>
        <form:input type="text" path="firstname" />
    </div>
    <div>
        <form:errors path="firstname" />
    </div>

    <div>Last name:</div>
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

    <button>Update</button>

</form:form>

</body>
</html>