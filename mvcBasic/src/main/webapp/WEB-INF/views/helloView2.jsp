<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<% String data  = (String) request.getAttribute("data"); %>
<body>
  <h2>  <%=data %> hello  mvc!!!</h2> 
</body>
</html>