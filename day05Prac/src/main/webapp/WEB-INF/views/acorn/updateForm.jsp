<%@page import="day05Prac.dto.Acorn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	Acorn acorn = (Acorn) request.getAttribute("acorn");
	%>

	<form action="/day05Prac/acorn/update" method="post">
		<input type="text" name="id" readonly="readonly"
			value="<%=acorn.getId()%>"><br> <input type="text"
			name="pw" value="<%=acorn.getPw()%>"><br> <input
			type="text" name="point" value="<%=acorn.getPoint()%>"><br>
		<input type="text" name="name" readonly="readonly"
			value="<%=acorn.getName()%>"><br> <input type="text"
			name="birthday" readonly="readonly" value="<%=acorn.getBirth()%>"><br>
	</form>

</body>
</html>