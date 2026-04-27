package simpletransaction;
 

import java.sql.*;


// 트랜잭션처리시 주의사항 
// 같은 커넥션이어야 한다
// 논리적인 하나의 단위(비지니스)가 모두 수행되거나 모두 수행되지 않게 하기 


//방법
//같은커넥션 얻어오기
//autoCommit을  false로 변경하기
//try 맨 아래에서  커밋수행  (모두 정상 수행)
//catch에서  롤백  ( 문제가 있는 경우 수행 )

public class Test4_트랜잭션처리하기 {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            // 1. DB 연결
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:testdb", "scott", "tiger"
            );
           
            
            //오토커밋
            conn.setAutoCommit(false);
       

            // =======================
            // 2. 주문 등록
            // =======================
            int orderId = 4; // 임의 주문번호
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
            int detailId = 5002; // 임의 상세번호
            String productId = "P100";
            int quantity = 3;
            double price = 5000.0;
            double subtotal = quantity * price;

            String detailSql = "INSERT INTO ORDER_DETAIL (DETAIL_ID, ORDER_ID, PRODUCT_ID, QUANTITY, PRICE, SUBTOTAL) "
                             + "VALUES (?, ?, ?, ?, ?, ? )";
            PreparedStatement detailPstmt = conn.prepareStatement(detailSql);
            detailPstmt.setInt(1, detailId);
            detailPstmt.setInt(2, orderId);
            detailPstmt.setString(3, productId);
            detailPstmt.setInt(4, quantity);
            detailPstmt.setDouble(5, price);
            detailPstmt.setDouble(6, subtotal);
            detailPstmt.executeUpdate();
            detailPstmt.close();

            System.out.println("  주문과 주문상세 1개 등록 완료 (Order ID: " + orderId + ")");
            //정상수행이 완료된 후 에 커밋
            conn.commit();
            

        } catch (Exception e) {
            System.out.println("  오류 발생: " + e.getMessage());
            
            try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
