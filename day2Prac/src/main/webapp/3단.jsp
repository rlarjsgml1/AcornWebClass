<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3단 제공하기</title>
<style>
table {
	border-collapse: collapse;
}

td {
	border: 1px solid black;
	padding: 8px;
}
</style>
</head>
<body>
	<h2>3단 제공하기</h2>
	<table>
		<%
		for (int i = 1; i <= 9; i++) {
		%>
		<tr>
			<td><%= "3*" + i + "=" + (3 * i) %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>