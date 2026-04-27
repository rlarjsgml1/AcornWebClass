<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="<%=request.getContextPath()%>/acornReg"  method="post">	
	<input type="text" name="id" ><br>
	<input type="text" name="pw" ><br>
	<input type="text" name="name" ><br>
	<button>회원가입</button>
</form>

</body>
</html>