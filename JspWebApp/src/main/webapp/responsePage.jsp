<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Response</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<%@ page import="java.util.Date" %>
<h1>YOUR REGISTRATION DATA IS AS FOLLOWS</h1>

<%
String firstname=request.getParameter("firstname");
String lastname=request.getParameter("lastname");
String username=request.getParameter("username");
String city=request.getParameter("city");
String email=request.getParameter("email");
String phone=request.getParameter("phone");
String password=request.getParameter("password");


Date date=new Date();
out.println("<h1> Hii, "+firstname+" "+lastname);
out.println("<p>["+username+"] ["+date+"]</p>");
out.println("<h3> YOUR REGISTRATION DATA IS AS FOLLOWS</h3>");
out.println("<h2> email address : "+email+"</h2>");
out.println("<h2> phone number : "+phone+"</h2>");
out.println("<h2> city : "+city+"</h2>");
%>
</body>
</html>