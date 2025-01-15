<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login My Construccion</title>
</head>
<body>
	    <h2>Login</h2>
    <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" name="username" required><br>
        <label for="password">Password:</label>
        <input type="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>
    <%
        if (request.getParameter("error") != null) {
    %>
        <p style="color:red;">Invalid username or password!</p>
    <%
        }
    %>
</body>
</html>