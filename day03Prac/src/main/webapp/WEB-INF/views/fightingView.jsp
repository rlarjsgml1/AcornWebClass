<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	String data = (String) request.getAttribute("data"); %>
<% //request.getAttribute("data"); 저장한 key을 사용 %>

	<h2>^^</h2>
	<!--  -->
	<p> <%=data %> 데이터!</p>
</body>
</html>