<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>서버 오류입니다</h2>

죄송합니다.
관리자에게 문의하세요 

 <%
 
 
	Integer code=	(Integer) request.getAttribute("javax.servlet.error.status_code");
	String message=	(String) request.getAttribute("javax.servlet.error.message");
	String uri=	(String) request.getAttribute("javax.servlet.error.request_uri");
 %>
 
 <%= code %>
 
 <%=message %>
 
 <%=uri %>
 
 <% %>
</body>
</html>