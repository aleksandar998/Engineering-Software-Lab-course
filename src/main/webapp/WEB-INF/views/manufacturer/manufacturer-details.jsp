<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<p>This is page for MANUFACTURER DETAILS...</p>

<c:if test="${not empty information}">
  <div>${information}</div>
</c:if>
<c:if test="${not empty exception}">
  <div>${exception}</div>
</c:if>

<form:form modelAttribute="manufacturerDto">
  <div>Name:</div>
  <div>
    <form:input type="text" path="name" size="60" readonly="true" />
  </div>
  <div>
    <form:errors path="name" />
  </div>

  <div>City number:</div>
  <div>
    <form:input type="text" path="cityDto.number" size="60" readonly="true" />
  </div>
  <div>City name:</div>
  <div>
    <form:input type="text" path="cityDto.name" size="60" readonly="true" />
  </div>
  <div>
    <form:errors path="cityDto" />
  </div>

  <div>
    <a href="${pageContext.request.contextPath}/manufacturer/edit/id/${manufacturerDto.id}">Edit</a>
  </div>
</form:form>

<form:form action="${pageContext.request.contextPath}/manufacturer/delete/${manufacturerDto.id}" modelAttribute="manufacturerDto" method="POST">
  <button>Delete</button>
</form:form>
