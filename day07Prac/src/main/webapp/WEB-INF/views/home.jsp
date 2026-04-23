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
	String path = request.getContextPath();
	%>


	<%
	String id = (String) session.getAttribute("id");
	%>

	<%
	if (id != null) {
	%>
	<%=id%>님 반갑습니다 ^^
	<a href="<%=path%>/logout">로그아웃</a>
	<%
	} else {
	%>
	<a href="<%=path%>/login">로그인</a>
	<%
	}
	%>





	<a href="<%=path%>/order.do">주문정보조회하기</a>

</body>
</html>