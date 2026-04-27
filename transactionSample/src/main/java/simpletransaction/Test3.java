package simpletransaction;
 

import java.sql.*;

public class Test3 {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            // 1. DB 연결
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:testdb", "scott", "tiger"
            );
           
            
            //
       

            // =======================
            // 2. 주문 등록
            // =======================
            int orderId = 2; // 임의 주문번호
            String customerId = "test01";
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
                             + "VALUES (?, ?, ?, ?, ?, ?  ,?)";
            PreparedStatement detailPstmt = conn.prepareStatement(detailSql);
            detailPstmt.setInt(1, detailId);
            detailPstmt.setInt(2, orderId);
            detailPstmt.setString(3, productId);
            detailPstmt.setInt(4, quantity);
            detailPstmt.setDouble(5, price);
            detailPstmt.setDouble(6, subtotal);
            detailPstmt.executeUpdate();
            detailPstmt.close();

            System.out.println(" 주문과 주문상세 1개 등록 완료 (Order ID: " + orderId + ")");

        } catch (Exception e) {
            System.out.println("❌ 오류 발생: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
