<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
HttpSession sess =request.getSession(false);
if(sess==null||sess.getAttribute("username")==null){
	response.sendRedirect("login.jsp");
	return;
}
String username=(String) sess.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
  <h2>Welcome, you are successfully logged in!</h2>
  <p>Username: <%= username %></p>
  <form action="LogoutServlet" method="post">
    <button type="submit">Logout</button>
  </form>
</body>
</html>