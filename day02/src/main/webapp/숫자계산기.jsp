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
 
String  su1_ =request.getParameter("su1");
String  su2_ =request.getParameter("su2");


int su1  =Integer.parseInt( su1_);
int su2  =Integer.parseInt( su2_) ;

int result  = su1+ su2;


%>


<div>  <%=result %></div>

</body>
</html>