<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 결과</title>
</head>
<body>

<% String animal = (String) session.getAttribute("animal"); 
	String flower = (String) session.getAttribute("flower");
%>

<h1>설문결과</h1>

<p>당신이 좋아하는 동물은? <%= animal %></p>
<p>당신이 좋아하는 꽃은? <%= flower %></p>
</body>
</html>
