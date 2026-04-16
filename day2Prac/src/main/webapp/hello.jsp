<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10까지의 합</title>
</head>
<body>

	<!--  10까지의 합 -->

	<!-- 내장 객체 request, response, out
 -->
	<%
	int sum = 0;
	for (int i = 0; i <= 10; i++) {
		sum += i;
	}
	out.println(sum + "^^^^");
	%>


</body>
</html>