package acorn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 

public class AcornDAO {
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
	
	
	public ArrayList<Customer> selectAll(){	
		//연결
		Connection con  =dbcon();
		
		//sql
		String sql="select * from acorntbl";		
		//sql실행
		PreparedStatement pst=null;
		ResultSet rs =null;
		
		ArrayList<Customer> list =new ArrayList<>();
		try {
			pst=con.prepareStatement(sql);
			rs =pst.executeQuery();
			
			while( rs.next()) {
				 String id= rs.getString(1);
				 String  pw = rs.getString(2);
				 String name  = rs.getString(3);
				
				list.add(  new Customer(id, pw, name));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//해제
		close(rs,pst, con);
		return list;		
	}
	
	
	
	public ArrayList<Customer> selectAll2(String[] query){	
		//연결
		Connection con  =dbcon();
	  //	String[]  query = { "dy", "yj"};		
		
		String str=" where  ";
		for( int i=0; i <query.length-1; i++) {
			str+= " id= ?  or ";
		}
		
		
		str+= " id= ? ";		
		
		//sql
		String sql=" select * from acorntbl " + str;		
	 	
		
		System.out.println(  sql);
		PreparedStatement pst=null;
		ResultSet rs =null;
		
		ArrayList<Customer> list =new ArrayList<>();
		try {
			pst=con.prepareStatement(sql);
			
			for( int i=0;  i<query.length ; i++) {
				String q = query[i];
				pst.setString(i+1, q);				 
			}
			 
			
			rs =pst.executeQuery();
			
			while( rs.next()) {
				 String id= rs.getString(1);
				 String  pw = rs.getString(2);
				 String name  = rs.getString(3);				
				list.add(  new Customer(id, pw, name));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//해제
		close(rs,pst, con);
		return list;		
	}
	 
	 
	 
	public void insert( Customer c) throws SQLException {
		
		
		Connection con = dbcon();
		String sql =" insert into acorntbl (id,pw,name) values( ?, ? ,?, ?)";
		
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c.getId());
			pst.setString(2, c.getPw());
			pst.setString(3, c.getName());
			
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();			
			
			
			System.out.println(" 예외발생되었음 ");
			//예외 되던지, 예외 다시 일으킨다
			throw e;
			 
		}
		
	}
	
	public int insert2( Customer c)  {
				
				int resultRow=0;
				Connection con = dbcon();
				String sql =" insert into acorntbl values( ?, ? ,?)";
				
				
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, c.getId());
					pst.setString(2, c.getPw());
					pst.setString(3, c.getName());
					
					
					resultRow = pst.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					//예외 되던지, 예외 다시 일으킨다
					 
				}
				
				return resultRow;
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
		AcornDAO dao = new AcornDAO();
		
		String[] ids= {"dy" ,"yj"};
		ArrayList<Customer> list  = dao.selectAll2( ids );
		System.out.println( list);
		 
		
	}

}
