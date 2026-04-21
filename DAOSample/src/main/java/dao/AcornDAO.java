package dao;

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
				String  id= rs.getString(1);
				String  pw= rs.getString(2);
				String  name= rs.getString(3);
				Customer c = new Customer( id, pw, name);
				list.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//해제
		finally{
			close(rs,pst, con);
		 
		}
		return list;		
	}
	
 
	
	public Customer selectOne( String id) {
		//db연결
		Connection con  =dbcon();
		//sql
		String sql =" select * from acorntbl where id= ? ";
		PreparedStatement pst=null;
		ResultSet rs = null;
		Customer c =null;
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, id);			
			//sq1실행
			//sql실행한 결과 Customer 객체로 만들기
			rs=pst.executeQuery();			
			if( rs.next() ) {
				String id_tmp = rs.getString(1);
				String pw_tmp = rs.getString(2);
				String name_tmp = rs.getString(3);
				c = new Customer( id_tmp, pw_tmp, name_tmp);				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//자원해제	
		finally {
			close( rs,pst, con);
		}
		return c;
	}	
	
	public void insertMember() {
		// db연결
		Connection con  =dbcon();
		// sql작성
		String sql="insert into acorntbl values(?,?,?)";
		PreparedStatement pst=null;
		try {
			// sql실행
			pst=con.prepareStatement(sql);
			pst.setString(1, "test9");
			pst.setString(2, "1234");
			pst.setString(3, "hong");
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// 연결해제	
		finally {
			close( pst, con);
		}
	}
	
	
	
	public void insertMember2(String id, String pw, String name) {
		// db연결
		Connection con  =dbcon();
		// sql작성
		String sql="insert into acorntbl(id, pw, name) values(?,?,?)";
		PreparedStatement pst=null;
		try {
			// sql실행
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			pst.setString(3, name);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// 연결해제	
		close( pst, con);		
	}
	
	
	
	public void insertMember3( Customer c) {
		// db연결
		Connection con  =dbcon();
		// sql작성
		String sql="insert into acorntbl(id, pw, name) values(?,?,?)";
		PreparedStatement pst=null;
		try {
			// sql실행
			pst=con.prepareStatement(sql);
			pst.setString(1, c.getId());
			pst.setString(2, c.getPw());
			pst.setString(3, c.getName());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// 연결해제	
		finally {
			close( pst, con);
		}
	}
	
	
	//삭제
	
	public void deleteOne(String id) {
		//연결
		//sql  작성
		//sql  실행
		//연결해제		
		Connection  con  =dbcon();
		String sql = " delete from acorntbl where id= ?  ";
		PreparedStatement  pst=null;
		try {
			  pst =con.prepareStatement(sql);
			  pst.setString(1, id); 
			  pst.executeUpdate();
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {		
			close(pst, con);
		}
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

	
	public void updateMember(String id, String pw) {
		//연결
		//변경 sql 작성
		//실행
		//자원반납		
		Connection con  =dbcon();
		PreparedStatement pst=null;
		String sql=" update acorntbl set pw =? where id = ? " ;
		try {
			pst= con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);			
			pst.executeUpdate();			
			
		} catch (SQLException e) {			 
			e.printStackTrace();
		}finally {		
			close( pst, con);
		}
		
	}
	  
	public static void main(String[] args) {
		AcornDAO dao = new AcornDAO();
		//ArrayList<String> list =dao.selectAll();
		//System.out.println( list);
		
		//dao.insertMember();
		//dao.insertMember2("test10", "0000", "kim");
		//Customer c= new Customer("test11","0000", "lee");;
		//dao.insertMember3(c);
		
		//Customer customer = dao.selectOne("dy");
		//System.out.println( customer);		
		//dao.deleteOne("test10");
		dao.updateMember( "mj", "5555" );
		
		//dao.updateMember2(String id, String pw);
		
	}

}
