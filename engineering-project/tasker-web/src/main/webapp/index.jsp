<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<body>
	<div>
		<form name="form" method="post" action="login">
			<label for="username">Username:</label> <input type="text"
				id="username" name="username" placeholder="Username" /> <label
				for="password">Password:</label> <input type="password"
				id="password" name="password" placeholder="Password" /> <input
				type="submit" value="Login" name="login" />
		</form>
	</div>
	<c:if test="${errMsg != null}">
		<div>
			${errMsg}
		</div>	
	</c:if>
</body>
</html>