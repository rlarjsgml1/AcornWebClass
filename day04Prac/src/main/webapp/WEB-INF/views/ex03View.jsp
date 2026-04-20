<%@page import="day04Prac.Score"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03View</title>
</head>
<body>

<%
    Score score = (Score) request.getAttribute("data");
%>

<h2>학생 점수 조회</h2>

<table border="1">
    <tr>
        <th>이름</th>
        <th>국어</th>
        <th>영어</th>
        <th>수학</th>
    </tr>
    <tr>
        <td><%= score.getName() %></td>
        <td><%= score.getKor() %></td>
        <td><%= score.getEng() %></td>
        <td><%= score.getMath() %></td>
    </tr>
</table>

</body>
</html>