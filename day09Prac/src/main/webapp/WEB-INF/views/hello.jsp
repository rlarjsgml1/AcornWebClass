<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>정상처리</h2>
<% int cnt = (int) request.getAttribute("cnt"); %>
<%= cnt %>

${cnt}
</body>
</html>