package simpletransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//주문등록하기      -  주문정보
//주문상세등록하기   -  티셔츠, 바지 
//트랜잭션 처리하기  모두 수행되거나 수행되지 않게 하기
public class 트랜잭션미사용하기 {

	public static void main(String[] args) {
		 
		
		  String driver="oracle.jdbc.driver.OracleDriver";
		  String url = "jdbc:oracle:thin:@localhost:1521:testdb"; // XE: Oracle Express Edition SID
		  String user = "scott";    // Oracle 계정
		  String password = "tiger"; // 계정 비밀번호

		
		  
		  Connection con=null;
		  PreparedStatement  pst1= null;
		  PreparedStatement  pst2= null;
		  
		  try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, user, password);
			if( con != null) System.out.println("ok"); 
			 
			
			//주문정보 등록하기
			String  orderSql  ="INSERT INTO ORDERS  (ORDER_ID, CUSTOMER_ID, ORDER_DATE, TOTAL_AMOUNT, STATUS) VALUES (?, ?, SYSDATE, ?, ?)";
			pst1= con.prepareStatement(orderSql);
			pst1.setInt(1, 1);
			pst1.setString(2, "hong");
			pst1.setInt(3, 1000);
			pst1.setString(4, "ready");
			
			pst1.executeUpdate();
						
			
			//주문 상세 등록하기
			
			String detailSql ="INSERT INTO ORDER_DETAIL (DETAIL_ID, ORDER_ID, PRODUCT_ID, QUANTITY, PRICE, SUBTOTAL) VALUES (?, ?, ?, ?, ?, ?,?)";
			
			pst2 =con.prepareStatement(detailSql);
			
			
			pst2.setInt(1, 1);
			pst2.setInt(2, 1);
			pst2.setString(3, "p001");
			pst2.setInt(4, 2);
			pst2.setInt(5, 500);
			pst2.setInt(6, 500 );		
			
			pst2.executeUpdate(); 
			
		 
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();			
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
		
		
		
		
		
	}

}
