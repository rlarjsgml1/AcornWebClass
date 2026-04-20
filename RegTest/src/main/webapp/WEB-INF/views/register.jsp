<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
    <h2>회원가입</h2>
    <form action="register" method="post">
        아이디: <input type="text" name="username" required><br><br>
        비밀번호: <input type="password" name="password" required><br><br>

        성별:<br>
        <input type="radio" name="gender" value="M" required> 남자
        <input type="radio" name="gender" value="F"> 여자
        <br><br>

        회원 유형:<br>
        <input type="radio" name="role" value="USER" required> 일반회원
        <input type="radio" name="role" value="ADMIN"> 관리자
        <input type="radio" name="role" value="SELLER"> 판매자
        <br><br>

        취미:<br>
        <input type="checkbox" name="hobby" value="1"> 운동
        <input type="checkbox" name="hobby" value="2"> 독서
        <input type="checkbox" name="hobby" value="3"> 게임
        <input type="checkbox" name="hobby" value="4"> 여행
        <br><br>

        <button type="submit">회원가입</button>
    </form>
</body>
</html>
