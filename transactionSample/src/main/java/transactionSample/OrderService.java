package transactionSample;

 

import java.sql.Connection;
import java.util.List;


//트랜잭션 처리 하기 !!!!



public class OrderService {	
    private OrderDAO orderDAO = new OrderDAO();
    private OrderDetailDAO detailDAO = new OrderDetailDAO();
    

    /**
     * 주문과 주문상세를 함께 저장 (트랜잭션) 처리하기 
     * 주의사항: 같은 커넥션객체를 사용해야 모두 수행되거나 모두 수행되지 않게 할 수 있다
     */
    public void placeOrder(Order order, List<OrderDetail> detailList) throws Exception {
        Connection conn = null;

        try {
        	
        	//같은 커넥션이어야  트갠잭션처리가 가능하다  커밋과 롤백이 가능하다  
            // 1. 커넥션 생성 및 트랜잭션 시작
            conn = DBUtil.dbcon();

            // 2. 주문 저장 후 생성된 order_id 받기
            int orderId = orderDAO.insertOrder(conn, order);

            // 3. 주문상세 저장
            for (OrderDetail detail : detailList) {
                detail.setOrderId(orderId);  // 주문상세에 주문번호 설정
                detailDAO.insertOrderDetail(conn, detail);
            }

            // 4. 모든 insert가 정상적으로 완료되면 commit
            conn.commit();
            System.out.println("  주문 트랜잭션 커밋 완료");

        } catch (Exception e) {
            // 예외 발생 시 rollback
            if (conn != null) {
                conn.rollback();
                System.out.println("  주문 트랜잭션 롤백: " + e.getMessage());
            }
            throw e; // Controller로 예외 던짐
        } finally {
            // 5. 커넥션 닫기
            if (conn != null) conn.close();
        }
    }
}
