package transactionSample;
 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {

	/**
	 * 주문 저장 후 생성된 주문번호 반환 (Oracle 시퀀스)
	 * @throws SQLException 
	 */
	public int insertOrder(Connection conn, Order order) throws SQLException  {
		 // 시퀀스로 주문번호 먼저 조회
        String seqSql = "SELECT SEQ_ORDER_ID.NEXTVAL FROM DUAL";
        PreparedStatement pst=null;
        ResultSet  rs=null; 
        int orderId = 0;
		try {
			   pst = conn.prepareStatement(seqSql);
			   rs = pst.executeQuery();
		     
		        if (rs.next()) {
		            orderId = rs.getInt(1);
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
       
		        try {
					if( rs != null)rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
					if( pst != null )pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        
		}
		

        // 주문 등록
        String sql = "INSERT INTO ORDERS (ORDER_ID, CUSTOMER_ID, ORDER_DATE, TOTAL_AMOUNT, STATUS) " +
                     "VALUES (?, ?, SYSDATE, ?, 'READY')";
        PreparedStatement pst2=null;
		try {
			pst2 = conn.prepareStatement(sql);
			pst2.setInt(1, orderId);
			pst2.setString(2, order.getCustomerId());
			pst2.setDouble(3, order.getTotalAmount());
			
			
			pst2.executeUpdate();
			pst2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 

        return orderId;
	}
}