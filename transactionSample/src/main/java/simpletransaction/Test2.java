package simpletransaction;


import java.sql.*;



// 주문과 주문상세는 하나의 논리적 단위이다
// 주문등록후 주문상세 등록에서 오류가 발생했다면 전부 취소되어야 한다 


public class Test2 {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            // 1. DB 연결
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:testdb", "scott", "tiger"
            );
            conn.setAutoCommit(false); // 트랜잭션 수동 처리

            
            // =======================
            // 2. 주문 등록
            // =======================
            
            
            int orderId = 8887; // 임의 주문번호
            String customerId = "user01"; 
            double totalAmount = 15000.0;

            String orderSql = "INSERT INTO ORDERS (ORDER_ID, CUSTOMER_ID, ORDER_DATE, TOTAL_AMOUNT, STATUS) "
                            + "VALUES (?, ?, SYSDATE, ?, 'READY')";
            PreparedStatement orderPstmt = conn.prepareStatement(orderSql);
            orderPstmt.setInt(1, orderId);
            orderPstmt.setString(2, customerId);
            orderPstmt.setDouble(3, totalAmount);
            orderPstmt.executeUpdate();
            orderPstmt.close();

            // =======================
            // 3. 주문 상세 등록 (한 개)
            // =======================
            int detailId = 5001; // 임의 상세번호
            String productId = "P100";
            int quantity = 3;
            double price = 5000.0;
            double subtotal = quantity * price;

            String detailSql = "INSERT INTO ORDER_DETAIL (DETAIL_ID, ORDER_ID, PRODUCT_ID, QUANTITY, PRICE, SUBTOTAL) "
                             + "VALUES (?, ?, ?, ?, ?, ?,?)";
            PreparedStatement detailPstmt = conn.prepareStatement(detailSql);
            detailPstmt.setInt(1, detailId);
            detailPstmt.setInt(2, orderId);
            detailPstmt.setString(3, productId);
            detailPstmt.setInt(4, quantity);
            detailPstmt.setDouble(5, price);
            detailPstmt.setDouble(6, subtotal);
            detailPstmt.executeUpdate();
            detailPstmt.close();

            // =======================
            // 4. 커밋
            // =======================
            conn.commit();
            System.out.println("  주문과 주문상세 1개 등록 완료 (Order ID: " + orderId + ")");

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
                System.out.println(" 오류 발생, 롤백: " + e.getMessage());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
