<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


  mvc1 view 화면입니다.
 
 <% String  result  = (String)request.getAttribute("msg"); %>
 <%=result %>
 
</body>
</html>