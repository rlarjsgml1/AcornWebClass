<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<% String[] danv2  =  (String[])request.getAttribute("danv2");
   String danv1  =  (String) request.getAttribute("danv1");
%>



<%= danv1 %>


<%
  for( int i=0  ; i< danv2.length; i++){
	   out.println( danv2[i]);
  }
%>

</body>

</html>