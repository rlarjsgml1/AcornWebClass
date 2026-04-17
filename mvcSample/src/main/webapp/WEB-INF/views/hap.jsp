<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%  Integer total  =  (Integer) request.getAttribute("total"); %>

<h2> 두 수의 합의 결과는</h2>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJf7T5RpWxt-f2J5pDiZe13EF2nw479SnYCQ&usqp=CAU">


<%= total %>


</body>
</html>