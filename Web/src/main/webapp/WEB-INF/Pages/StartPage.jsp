<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 13.08.16
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Animal Social Network - Authorization</title>
</head>
<body>
	<h4>Sign in...</h4>
	<form action="/signIn" method="get">
		<input type="text" placeholder="login" name="name" autofocus>
		<input type="submit" value="Sign in">
	</form>
	<form action="/signUp" method="post">
		<h4>...or Sign up</h4>	
		<p><input type="text" placeholder="name" name="name"></p>
		<p><input type="text" placeholder="year of birth" name="year"></p>
		<p><input type="text" placeholder="month of birth" name="month"></p>
		<p><input type="text" placeholder="day of birth" name="day">
  	      <input type="submit" value="Sign up"></p>
	</form>
</body>
</html>
