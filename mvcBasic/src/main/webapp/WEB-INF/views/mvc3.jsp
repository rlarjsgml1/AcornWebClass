<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>내가 좋아하는 거 !!</h2>


<%
String[]  list  = (String[])request.getAttribute("likes");

for( String item : list){
	out.print( item +"<br>");
}

%>
</body>
</html>