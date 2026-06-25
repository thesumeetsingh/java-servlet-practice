
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Failed</title>

<link rel="stylesheet" href="style.css">

<style>

.failed{
    color:red;
    text-align:center;
    margin-bottom:25px;
}

.action-btn{
    display:block;
    width:100%;
    text-align:center;
    text-decoration:none;
    background:#2196F3;
    color:white;
    padding:12px;
    border-radius:8px;
    margin-top:15px;
    font-weight:bold;
}

.action-btn:hover{
    background:#1565C0;
}

</style>

</head>

<body>

<div class="container">

    <div class="card">

        <h1>Registration Failed</h1>

        <div class="failed">
            Unable to register your account.
            <br>
            Please try again.
        </div>

        <a href="index.html" class="action-btn">
            Register Again
        </a>

        <a href="login.jsp" class="action-btn">
            Already Registered? Login
        </a>

    </div>

</div>

</body>
</html>

