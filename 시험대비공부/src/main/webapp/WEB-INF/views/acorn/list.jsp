<%@page import="day05Prac.dto.Acorn"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
<style>
table {
	border: 1px solid black;
	margin: 0 auto;
}

td {
	border: 1px solid black;
	padding: 6px 10px;
}

h2 {
	text-align: center;
}
</style>
</head>
<body>
	<%
	ArrayList<Acorn> list = (ArrayList<Acorn>) request.getAttribute("list");
	%>

	<h2>에이콘 학생 전체조회</h2>

	<table>
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>비밀번호</td>
			<td>포인트</td>
			<td>생일</td>
		</tr>

		<%
		for (Acorn acorn : list) {
		%>
		<tr>
			<td><%=acorn.getId()%></td>
			<td><%=acorn.getName()%></td>
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
