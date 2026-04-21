<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="java.util.ArrayList" %>
<%@ page import ="dao.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
border:1px solid black;
border-collapse:collapse;
width:600px;
margin:0 auto;
}
td{
border:1px solid black;
text-align: center;
}

header{
padding:20px;
background-color: blue;
text-align: center;
margin-bottom: 20px;s
}
</style>
</head>
<body>

<header>
<h2>에이콘 학생리스트</h2>
</header>



<% ArrayList<Customer> list  =(ArrayList<Customer>) request.getAttribute("list"); %>

<table>
<tr>
<td>아이디</td>
<td>비번</td>
<td>이름</td>
</tr>
<% for( int i=0; i< list.size() ;i++){
	Customer item  = list.get(i);
%>
<tr>
<td> <%=item.getId() %></td>
<td> <%=item.getPw() %></td>
<td><%=item.getName() %></td>
</tr>
<%}%>
 
</table>


	 


</body>
</html>