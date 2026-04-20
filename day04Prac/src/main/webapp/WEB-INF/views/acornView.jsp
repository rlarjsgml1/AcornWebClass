<%@page import="day04Prac.Acorn"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border: 1px solid black;
	width: 500px;
	margin: 0 auto;
	border-collapse: collapse;
	text-align: center;
}

td {
	border: 1px solid black;
}
</style>
</head>
<body>

	<%
	ArrayList<Acorn> list = (ArrayList<Acorn>) request.getAttribute("list");
	%>

	<table>
		<tr>
			<td>이름</td>
			<td>아이디</td>
			<td>비번</td>
			<td>포인트</td>
			<td>생일</td>
		</tr>
		<%
		for (int i = 0; i < list.size(); i++) {
			Acorn acorn = list.get(i);
		%>

		<tr>
			<td><%=acorn.getName()%></td>
			<td><%=acorn.getId()%></td>
			<td><%=acorn.getPw()%></td>
			<td><%=acorn.getPoint()%></td>
			<td><%=acorn.getBirth()%></td>
		</tr>

		<%
		}
		%>


	</table>
</body>
</html>