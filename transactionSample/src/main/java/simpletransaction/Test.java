package simpletransaction;
import java.sql.*;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            // 1. DB 연결
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:testdb", "scott", "tiger"
            );
            conn.setAutoCommit(false); // 트랜잭션 수동처리

            // =======================
            // 2. 주문(Order) 등록
            // =======================
            int orderId = 0;

            // 2-1. 시퀀스로 주문번호 미리 발급
            String seqSql = "SELECT SEQ_ORDER_ID.NEXTVAL FROM DUAL";
            PreparedStatement seqStmt = conn.prepareStatement(seqSql);
            ResultSet seqRs = seqStmt.executeQuery();
            if (seqRs.next()) {
                orderId = seqRs.getInt(1);
            }
            seqRs.close();
            seqStmt.close();

            // 2-2. 주문 INSERT
            String insertOrderSql = "INSERT INTO ORDERS (ORDER_ID, CUSTOMER_ID, ORDER_DATE, TOTAL_AMOUNT, STATUS) "
                    + "VALUES (?, ?, SYSDATE, ?, 'READY')";
            PreparedStatement orderPstmt = conn.prepareStatement(insertOrderSql);
            orderPstmt.setInt(1, orderId);
            orderPstmt.setString(2, "user01");     // 예시 고객 ID
            orderPstmt.setDouble(3, 30000.00);     // 총 주문금액
            orderPstmt.executeUpdate();
            orderPstmt.close();

            // =======================
            // 3. 주문 상세(OrderDetail) 등록
            // =======================
            List<String> productIds = Arrays.asList("P100", "P200", "P300");
            List<Integer> quantities = Arrays.asList(2, 1, 3);
            List<Double> prices = Arrays.asList(5000.0, 10000.0, 5000.0);

            for (int i = 0; i < productIds.size(); i++) {

                // 3-1. DETAIL_ID 시퀀스 생성
                int detailId = 0;
                String seqDetailSql = "SELECT SEQ_DETAIL_ID.NEXTVAL FROM DUAL";
                PreparedStatement seqDetailStmt = conn.prepareStatement(seqDetailSql);
                ResultSet rsDetail = seqDetailStmt.executeQuery();
                if (rsDetail.next()) {
                    detailId = rsDetail.getInt(1);
                }
                rsDetail.close();
                seqDetailStmt.close();

                // 3-2. INSERT
                String insertDetailSql =
                        "INSERT INTO ORDER_DETAIL (DETAIL_ID, ORDER_ID, PRODUCT_ID, QUANTITY, PRICE, SUBTOTAL) "
                                + "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement detailPstmt = conn.prepareStatement(insertDetailSql);
                double subtotal = quantities.get(i) * prices.get(i);
                detailPstmt.setInt(1, detailId);
                detailPstmt.setInt(2, orderId);
                detailPstmt.setString(3, productIds.get(i));
                detailPstmt.setInt(4, quantities.get(i));
                detailPstmt.setDouble(5, prices.get(i));
                detailPstmt.setDouble(6, subtotal);
                detailPstmt.executeUpdate();
                detailPstmt.close();
            }

            // =======================
            // 4. 커밋
            // =======================
            
            conn.commit();
            System.out.println(" 주문과 주문상세가 모두 등록완료  트랜잭션 성공 (Order ID: " + orderId + ")");

        } catch (Exception e) {
            // =======================
            // 5. 예외 발생 시 롤백
            // =======================
            try {
                if (conn != null) conn.rollback();   // 오류발생으로  롤백처리   트랜잭션 취소
                System.out.println("  오류 발생: " + e.getMessage());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // =======================
            // 6. 자원 정리
            // =======================
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
