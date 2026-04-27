<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<link href="/modulePrj/css/header.css"   rel="stylesheet"  type="text/css">
<link href="<%=request.getContextPath()%>/css/footer.css"   rel="stylesheet"  type="text/css">

</head>
<body>

<!--  header -->
<jsp:include page="/WEB-INF/views/common/header.jsp" />

List 내용입니다.

<jsp:include page="/WEB-INF/views/common/banner.jsp" />



<!-- footer -->
<jsp:include page="/WEB-INF/views/common/footer.jsp" />



</body>
</html>