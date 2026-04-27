<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>이미지 보기</title>
</head>
<body>
    <%
        String fileName = (String) request.getAttribute("fileName");
        if (fileName != null) {
            fileName = URLDecoder.decode(fileName, "UTF-8");
    %>
        <h2>이미지 미리보기</h2>
        <img src="<%=request.getContextPath()%>/upload/<%=fileName%>" alt="업로드 이미지" style="max-width:400px;"><br><br>
     
    <%
        } else {
    %>
        <p>파일이 없습니다.</p>
    <%
        }
    %>
</body>
</html>
