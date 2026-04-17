package acorn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 

public class TestDB {

	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		Connection  con=null;
		PreparedStatement pst =null;
		ResultSet rs =null;		
		try {
			Class.forName(driver);			
			con = DriverManager.getConnection(url, user, password);
			if( con !=null) System.out.println("ok");			
			String sql="select  name  from acorntbl ";
			pst =con.prepareStatement(sql);
		    rs  =pst.executeQuery();			
			while( rs.next()) {
				System.out.println( rs.getString(1));
			} 		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}finally {  // 자원반납  예외가발생하든 하지않든 모두 수행  , 역순으로 close
		
			if(rs!=null )
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if( con!= null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		

	}

}
