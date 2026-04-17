<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
	border:1px solid black;
	}
</style>
</head>
<body>

<% String[] dan3 =  (String[]) request.getAttribute("aaa"); %>
<table>

<%for(String str :dan3){%>
<tr>
<td><%=str %></td>
</tr>
<%} %>
</table>
</body>
</html>