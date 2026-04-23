<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%  String  path  =  request.getContextPath(); %>
 <a href="/sessionCart/cart">장바구니 </a>
 
 
 <a href="<%=path %>/list">상품리스트 </a>
</body>
</html>