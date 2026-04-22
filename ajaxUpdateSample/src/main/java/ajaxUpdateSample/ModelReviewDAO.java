package ajaxUpdateSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelReviewDAO {
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="1234";
	
	
	
	
	public Connection dbcon() {
		
		Connection con = null;
		try {
			Class.forName(driver);
			con  =DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	
	public ArrayList<ReviewDTO>  selectAll() {
		
		Connection con = dbcon();
		String sql =" select * from reviewtbl";
		
		
		ArrayList<ReviewDTO> list = new ArrayList<>();
		
		try {
			PreparedStatement  pst= con.prepareStatement(sql);
			ResultSet rs =pst.executeQuery();
			while( rs.next()) {
				String id  = rs.getString(1);
				String content  = rs.getString(2);
				
				list.add( new ReviewDTO( id, content));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	
	public int insertReview( ReviewDTO review) {
		
		Connection con = dbcon();		
		String sql ="insert into reviewtbl  values( ?,?)";
		
		int cnt=0;
		try {
			
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setString(1, review.getId());
			pst.setString(2, review.getContent());
			cnt =pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return cnt;
	}
	

	public int  deleteReview( String id) {
		
		Connection con = dbcon();		
		String sql ="delete reviewtbl where id = ?";
		
		int cnt=0;
		try {
			
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setString(1, id);
			cnt= pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return cnt;
	}
	
	
	
	public int updateReview( ReviewDTO review) {
		Connection con =dbcon();
		
		int cnt=0;
		String sql="update  reviewtbl set content=?  where id= ? ";
		
		try {
			PreparedStatement  pst = con.prepareStatement(sql);
			pst.setString(1,  review.getContent());
			pst.setString(2,  review.getId());
			cnt=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return cnt;
	}
	
	
	

}
