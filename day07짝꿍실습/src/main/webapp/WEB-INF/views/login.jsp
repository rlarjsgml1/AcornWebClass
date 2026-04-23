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

<h2>로그인</h2>
<div class="loginform">
<form action="<%=path%>/login" method="post">
<input type="text" name="id"> <br>
<input type="password" name="pw"> <br>
<button>로그인</button>
</form>
</div>

</body>
</html>