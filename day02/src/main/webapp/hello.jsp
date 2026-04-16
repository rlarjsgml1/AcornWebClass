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
 td{
 	border:1px solid black;
 }
</style>
</head>
<body>


 
<%  //자바코드 작성  
   // request, response , out
   
   int sum=0;

   for( int i=1 ; i<=10; i++){
	   sum += i;
   }   
   
   out.println( sum);
   
%>




<%= sum %>

<table>
<tr>
<td> <%=sum %></td>
</tr>
</table>

</body>
</html>