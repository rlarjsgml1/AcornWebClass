package transactionSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailDAO {
 
	
	
	// 주문 상세 등록
	public void insertOrderDetail( Connection conn,  OrderDetail detail) throws SQLException   { 
		 
		String sql = "INSERT INTO  ORDER_DETAIL (DETAIL_ID, ORDER_ID, PRODUCT_ID, QUANTITY, PRICE, SUBTOTAL) "
				+ "VALUES (  SEQ_DETAIL_ID.nextval,  ?, ?, ?, ?, ?)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, detail.getOrderId());
			pst.setString(2, detail.getProductId());
			pst.setInt(3, detail.getQuantity());
			pst.setDouble(4, detail.getPrice());
			pst.setDouble(5, detail.getSubtotal());

			pst.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	} 
}
