package day04Prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
 

/*
  
  
  1. 오라클드라이버 라이브러리 해당위치에 두기 
  2. Class.forName() 클래스로딩
  3. DriverManager를 통해서 디비연결-  연결정보 ,사용자, 비번, url  => Connection  객체를 반환 받음 
  4. 문장얻어오기  PreparedStatement얻어오기 
  5. sql  작성하기 
  6. sql실행하기 , 조회
  7. 실행결과를  자바객체로 만들기 (ArrayList<Acorn> , Acorn 
  
 
 */


//DAO 한 개가  => 테이블 한 개 
//조인같은 경우는 ?  중심테이블에 두면 된다. 
public class AcornDAO {
	
	//
	String driver ="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";  // system
	String password="tiger"; //1234
	
	
	
	//디비연결 매서드 
	//기능: 디비연결정보를 이요해서 데이터베이스에 연결하기
	//입력: 
	//반환: 연결객체 ( Connection)
	public Connection  dbcon() {
		
		Connection con  = null;
		
		//
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return con;		
	}
	
	
	/*
	 * 기능: 학생전체조회
	 * 입력:x
	 * 반환 : ArrayList<Acorn>
	 * 
	 */	
	//                         findAll()
	public  ArrayList<Acorn>   selectAll(){
		
		//디비연결
		Connection con  =dbcon();	
		PreparedStatement  pst = null;
		ResultSet  rs = null;
		
		String sql  ="select * from acorntbl ";		
		ArrayList<Acorn> list = new ArrayList<>();  // 준비 !!
		
		 
		
		try {
			pst  =	con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while( rs.next()) {  // rs => 한 행(테이블의 레코드 값이 담겨 있음) 
				//System.out.println(rs.getString(1));
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				int point = rs.getInt(4);
				java.util.Date  birth = rs.getDate(5);			
//				/Acorn(String id, String pw, String name, int point, Date birth) {
				Acorn acorn = new Acorn(id, pw, name, point, birth);
				list.add(acorn);				
			}			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//자원 정리 , 거꾸로 한다  con , pst, rs    -> rs, pst, con   종료하기
			
			if( rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			//
			
			if( pst != null)
				try { 
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		
			//
			if( con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
		}
		
		return list;
		
		
	}
	
	
	//close하기 매서드 
	
	
	public static void main(String[] args) {
		
//		AcornDAO dao = new AcornDAO();
//		Connection con  =dao.dbcon();   // 올바른연결를 반환 ok ,   null 반환  fail  - 연결
//		System.out.println(con);
//		
//		if( con != null) {
//			System.out.println("디비 오케이");
//		}
//		
		AcornDAO dao = new AcornDAO();
		ArrayList<Acorn> list  =dao.selectAll();
		
		System.out.println(list );
		
		
	}
	
	//전체조회 
	
	//한 개 조회
	
	//등록하기 
	
	//변경하기
	
	//삭제하기

}
