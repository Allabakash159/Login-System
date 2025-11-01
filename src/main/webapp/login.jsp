<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
<label>Username: <input type="text" name="username" required></label>
<br>
<br>
<label>Password: <input type="password" name="password" required></label>
<br>
<br>
<button type="submit">Login</button>
</form>
<p style="color:red">${error}</p>
</body>
</html>