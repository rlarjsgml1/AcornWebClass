<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>내 위치로 지도 표시</title>
</head>
<body>
<!-- 지도를 표시할 div -->
<div id="map" style="width:100%;height:350px;"></div>

<!-- 카카오 지도 API -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=897fcb79645c2d3bae311019c8d27193"></script>
<script>
    var mapContainer = document.getElementById('map'),
        mapOption = { 
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 초기 지도 중심좌표
            level: 3 // 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption);

    // HTML5의 geolocation으로 현재 위치 가져오기
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            var lat = position.coords.latitude;   // 위도
            var lon = position.coords.longitude;  // 경도
            
            var locPosition = new kakao.maps.LatLng(lat, lon); // 좌표 생성
            var message = '<div style="padding:5px;">현재 위치입니다.</div>'; // 인포윈도우 내용
            
            // 마커와 인포윈도우 표시
            displayMarker(locPosition, message);
        }, function(error) {
            console.log("위치 정보를 가져오지 못했습니다.", error);
        });
    } else {
        // 위치 정보 지원 안될 때
        var locPosition = new kakao.maps.LatLng(33.450701, 126.570667);
        var message = 'geolocation을 사용할 수 없어요.';
        displayMarker(locPosition, message);
    }

    // 지도에 마커와 인포윈도우를 표시하는 함수
    function displayMarker(locPosition, message) {
        var marker = new kakao.maps.Marker({
            map: map,
            position: locPosition
        });

        var infowindow = new kakao.maps.InfoWindow({
            content: message,
            removable: true
        });

        infowindow.open(map, marker);
        map.setCenter(locPosition); // 지도 중심을 현재 위치로 이동
    }
</script>
</body>
</html>
l>