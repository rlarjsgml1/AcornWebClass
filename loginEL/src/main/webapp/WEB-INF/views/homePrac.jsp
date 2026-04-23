<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>메인화면 </h2>



<c:if test="${id ==null }">
   로그인 안되어 있음
</c:if> 


<c:if test="${sessionScope.id != null }">
   로그인 되어 있다 반갑습니다  ${id}님
</c:if>

</body>
</html>