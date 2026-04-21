<%@page import="day05Prac.dto.Acorn"%>
<%@page import="java.util.ArrayList"%>
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
    margin:0 auto;
  }
  td{
   border:1px solid black;
  }
  
  h2{
  text-align: center;
  }
</style>
</head>
<body>

<%   
 String str="i love java";  
 Object o  =str;   //업캐스팅 
 char result  = ((String) o).charAt(0);      // 올바른 다운캐스팅  성공
 out.println( result);
 %>
<%  ArrayList<Acorn>     list  = ( ArrayList<Acorn>  ) request.getAttribute("list"); %>

<h2> 에이콘 학생 명단 조회</h2>

<table>

<tr>
<td>아이디</td>
<td>이름</td>
<td>비번</td>
<td>포인트</td>
<td>생일</td>
</tr>
<!-- 실제 데이터가 보여질 부분 -->
<%  for( Acorn  acorn: list){ %>
<tr>
<td><%=acorn.getId() %></td>
<td><%=acorn.getName() %></td>
<td><%=acorn.getPw() %></td>
<td><%=acorn.getPoint() %></td>
<td><%=acorn.getBirth()%></td>
</tr>
<%} %>

</table>
</body>
</html>