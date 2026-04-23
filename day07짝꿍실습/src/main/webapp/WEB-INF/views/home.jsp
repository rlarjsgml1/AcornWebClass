<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/food.css">
</head>
<body>
<%String path = request.getContextPath(); %>
<%String id = (String)session.getAttribute("id"); %>

<h2>음식 추천 써비스~~</h2>

<div class="loginbtn">
<a href="<%=path%>/login">로그인</a>
</div>

</body>
</html>