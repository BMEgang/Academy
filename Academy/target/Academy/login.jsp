<%--
  Created by IntelliJ IDEA.
  User: ganghu
  Date: 12/27/21
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body>
<center><h1>Admin Login</h1></center>
<form action="AdminControllerServlet" method="post">
    <div class="container">
        <input type="hidden" name="command" value="LOGIN" />
        <label>Username : </label>
        <br/>
        <input type="text" placeholder="Enter Username" name="username" required>
        <br/>
        <label>password : </label>
        <br/>
        <input type="password" placeholder="Enter password" name="password" required>
        <br/>
        <button type="submit">Login</button>
        <br/>
        <input type="checkbox" checked="checked"> Remember me
    </div>
</form>
</body>
</html>
