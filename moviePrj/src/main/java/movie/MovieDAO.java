package movie;
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 

public class MovieDAO {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	
	public Connection dbcon() {		 
		Connection con = null;
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, password);
			if( con != null) System.out.println( "ok");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;		 	
	}
	
	
	 
	
	public ArrayList<Movie> selectAll(){	
		//연결
		Connection con  =dbcon();
		
		//sql
		String sql="select * from movietbl";		
		//sql실행
		PreparedStatement pst=null;
		ResultSet rs =null;
		
		ArrayList<Movie> list =new ArrayList<>();
		try {
			pst=con.prepareStatement(sql);
			rs =pst.executeQuery();
			
			while( rs.next()) {
				String  code= rs.getString(1);
				String  title= rs.getString(2);
				String  imgurl= rs.getString(3);
				String genre  = rs.getString(4);
				
				Movie c = new Movie( code, title, imgurl, genre);
				list.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//해제
		close(rs,pst, con);
		return list;		
	}
	
	 
	 
	 
	
	public void close( AutoCloseable ...a) {
		for( AutoCloseable  item : a) {
		   try {
			item.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
		
	}

 
	public static void main(String[] args) {
		MovieDAO dao = new MovieDAO();
		
		ArrayList<Movie> list  =dao.selectAll();
		System.out.println( list);
		 
	}

}
