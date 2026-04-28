<%@page import="listPrj.TravelPlace"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%
    List<TravelPlace> list = (List<TravelPlace>) request.getAttribute("places");
%>
<html>
<head>
    <title>여행지 목록 수정</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h2>여행지 목록 수정</h2>

<div id="travelList">
<% for(TravelPlace p : list) { %>
    <div style="border:1px solid #ccc; padding:10px; margin:10px;">
        <input type="hidden" name="id" value="<%= p.getId() %>" />
        <div><strong>ID:</strong> <%= p.getId() %></div>
        <div>
            <label>위도: </label>
            <input type="text" name="latitude" value="<%= p.getLatitude() %>" />
        </div>
        <div>
            <label>경도: </label>
            <input type="text" name="longitude" value="<%= p.getLongitude() %>" />
        </div>
        <div>
            <label>내용:</label><br/>
            <textarea name="content" rows="3" cols="50"><%= p.getContent() %></textarea>
        </div>
    </div>
<% } %>
</div>

<button onclick="saveAll()">저장</button>

<script>
function saveAll() {
    let placeList = [];

    $("#travelList > div").each(function() {
        let id = $(this).find("input[name='id']").val();
        let latitude = $(this).find("input[name='latitude']").val();
        let longitude = $(this).find("input[name='longitude']").val();
        let content = $(this).find("textarea[name='content']").val();

        placeList.push({
            id: id,
            latitude: latitude,
            longitude: longitude,
            content: content
        });
    });

    
    console.log("서버로 전송될 데이터:", placeList);  // 여기에 출력
    $.ajax({
        url: "/listPrj/updateAll",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(placeList),
        success: function(response) {
            alert("전체 업데이트 완료!");
        },
        error: function() {
            alert("업데이트 실패!");
        }
    });
}
</script>

</body>
</html>
