<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <style>
        input, select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>
</head>

<body>
<h2>Login</h2>

<form action="login" method="POST">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" placeholder="Username">
    <label for="password">Password:</label>
    <input type="password" id="password" name="password">
    <input type="submit" value="Login" name="login">
</form>
<c:if test="${errMsg != null }">

    <div>${errMsg}</div>
</c:if>

</body>
</html>
