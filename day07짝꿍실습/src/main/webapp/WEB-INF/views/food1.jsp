<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음식 선택 1단계</title>
<link rel="stylesheet" href="css/survey.css">
</head>
<body>
	<form action="/day07짝꿍실습/food2" method="get">
		<input type="radio" name="food" value="한식">한식 <br>
		<input type="radio" name="food" value="중식">중식 <br>
		<input type="radio" name="food" value="양식">양식 <br>
		<button>Next</button>
	</form>

</body>
</html>
