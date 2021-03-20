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
  <p>This is page for MANUFACTURER CONFIRM...</p>

  <c:if test="${not empty information}">
    <div>${information}</div>
  </c:if>
  <c:if test="${not empty exception}">
    <div>${exception}</div>
  </c:if>


  <form:form action="${pageContext.request.contextPath}/manufacturer/saveOrUpdate" 
             method="POST" 
             modelAttribute="manufacturerDto">
    
    <form:hidden path="id" />
             
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
      <button id="save">Confirm</button>
    </div>
  </form:form>
  
</body>
</html>