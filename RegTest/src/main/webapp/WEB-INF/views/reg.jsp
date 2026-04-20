<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/RegTest/reg" method="post">
  <h2>회원가입</h2>

  <label for="username">아이디:</label>
  <input type="text" id="username" name="username" required><br><br>

  <label for="password">비밀번호:</label>
  <input type="password" id="password" name="password" required><br><br>

  <label>성별:</label><br>
  <input type="radio" id="male" name="gender" value="M" required>
  <label for="male">남자</label><br>

  <input type="radio" id="female" name="gender" value="F">
  <label for="female">여자</label><br><br>
  
  
  회원 유형: <br>
        <input type="radio" name="role" value="USER" required> 일반회원
        <input type="radio" name="role" value="ADMIN"> 관리자
        <input type="radio" name="role" value="SELLER"> 판매자
        <br><br>


 취미: <br>
        <input type="checkbox" name="hobby" value="운동"> 운동
        <input type="checkbox" name="hobby" value="독서"> 독서
        <input type="checkbox" name="hobby" value="게임"> 게임
        <input type="checkbox" name="hobby" value="여행"> 여행
        <br><br>
  <button type="submit">회원가입</button>
</form>

</body>
</html>