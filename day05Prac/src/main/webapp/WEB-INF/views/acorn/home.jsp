<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<img alt="" src="/day05Prac/imgs/a.jpg">

<h2>에이콘 학생 관리</h2>

<ul>
	<li><a href="/day05Prac/acorn/list">학생전체 조회하기</a></li>
	<li><a href="/day05Prac/acorn/reg">학생 등록하기</a></li>
	<li>학생 조회하기 -> 변경
		<form action="/day05Prac/acorn/detail" method = "get" >
		<input type="text" name ="id">
		<button>조회하기</button>
		</form>
		</li>
	<li>학생 탈퇴하기
		<form action="/day05Prac/acorn/delete" method = "post">
			<input type="text" name ="id">
			<button>탈퇴하기</button> 
		</form>
	</li>
</ul>

</body>
</html>