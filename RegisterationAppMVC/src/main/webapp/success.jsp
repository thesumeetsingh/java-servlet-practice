<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Successful</title>

<link rel="stylesheet" href="style.css">

<style>
.success{
    text-align:center;
    color:green;
    margin-bottom:25px;
}
</style>

</head>

<body>
<%
String user=(String) session.getAttribute("firstname")+session.getAttribute("lastname");
%>
<div class="container">

    <div class="card">

        <h1>Registration Successful</h1>

        <div class="success">
            Welcome <b><%= user %></b> !
            <br><br>
            Your account has been created successfully.
        </div>

        <form action="login" method="post">

            <div class="input-group">
                <label>Username</label>
                <input type="text" name="username" required>
            </div>

            <div class="input-group">
                <label>Password</label>
                <input type="password" name="password" required>
            </div>

            <button type="submit">
                Login
            </button>

        </form>

    </div>

</div>

</body>
</html>
