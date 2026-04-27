<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>주문 화면</title>
</head>
<body>
    <h2>주문 등록</h2>
    <form action="${pageContext.request.contextPath}/order/insert" method="post">
        고객 ID: <input type="text" name="customerId"><br><br>

        상품 1<br>
        상품ID: <input type="text" name="productId"><br>
        수량: <input type="text" name="quantity"><br>
        가격: <input type="text" name="price"><br><br>

        상품 2<br>
        상품ID: <input type="text" name="productId"><br>
        수량: <input type="text" name="quantity"><br>
        가격: <input type="text" name="price"><br><br>

        <button type="submit">주문 등록</button>
    </form>
</body>
</html>
