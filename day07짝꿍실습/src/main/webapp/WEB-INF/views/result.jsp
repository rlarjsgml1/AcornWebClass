<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택 결과</title>
<link rel="stylesheet" href="css/survey.css">
<style>
    /* 이미지 스타일 추가 */
    .food-img {
        width: 250px; /* 적절한 크기로 조절 */
        height: auto;
        border-radius: 10px;
        margin: 20px 0;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    }
</style>
</head>
<body>
<%
    // 세션에서 값 가져오기
    String food = (String) session.getAttribute("food");
    String food1 = (String) session.getAttribute("food1");
    String food2 = (String) session.getAttribute("food2");
    String menu = (String) session.getAttribute("menu");
    
    // 경로 변수 (Context Path 자동 설정)
    String path = request.getContextPath();
%>

    <div class="result-container">
        <h1>음식 선택 결과</h1>
        
        <p><span>1단계 선택</span> <span><%= (food != null) ? food : "미선택" %></span></p>
        <p><span>2단계 선택</span> <span><%= (food1 != null) ? food1 : "미선택" %></span></p>
        <p><span>3단계 선택</span> <span><%= (food2 != null) ? food2 : "미선택" %></span></p>
        <p><span>추천 메뉴</span> <span><%= (menu != null) ? menu : "없음" %></span></p>

        <% if (menu != null && !menu.isEmpty()) { %>
            <div class="menu-image">
                <img src="<%=path%>/imges/<%=menu%>.jpg" alt="<%=menu%>" class="food-img">
            </div>
        <% } %>

        <form action="<%=path%>/logout" method="get">
            <button>로그 아웃</button>
        </form>
    </div>
</body>
</html>