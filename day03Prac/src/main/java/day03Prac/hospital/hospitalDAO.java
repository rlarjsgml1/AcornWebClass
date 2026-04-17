package day03Prac.hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//테이블(acorntbl) 하나당  DAO 한 개 만든다
public class hospitalDAO {

	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	
	public Connection dbcon() {		
		Connection con=null;
		try {
			Class.forName(driver);
			con  =DriverManager.getConnection(url, user, password);
			if( con != null) System.out.println("db ok");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;		
	}		
	//학생정보 조회	
	public  ArrayList<Hospital> selectAll(){		
		ArrayList<Hospital> list= null;
		list = new ArrayList<>();		
		//db연결
		 Connection con  =dbcon();
		 PreparedStatement pst= null;
		 ResultSet  rs = null;
		 
		 try {
			//sql작성
			 String sql=
			 		 "SELECT M.RECORD_ID             AS 진료내역번호,\r\n"
			 		+ "       P.PATIENT_NAME          AS 환자명,\r\n"
			 		+ "       D.DOCTOR_NAME           AS 의사명,\r\n"
			 		+ "       M.DIAGNOSIS_NAME        AS 진단명,\r\n"
			 		+ "       M.TREATMENT_CONTENT     AS 진료내용,\r\n"
			 		+ "       M.PRESCRIPTION_CONTENT  AS 처방내용,\r\n"
			 		+ "       M.TREATMENT_DATE        AS 진료일자\r\n"
			 		+ "FROM HOSP_MEDICAL_RECORD M\r\n"
			 		+ "JOIN HOSP_RESERVATION R\r\n"
			 		+ "  ON M.RESERVATION_ID = R.RESERVATION_ID\r\n"
			 		+ "JOIN HOSP_PATIENT P\r\n"
			 		+ "  ON R.PATIENT_ID = P.PATIENT_ID\r\n"
			 		+ "JOIN HOSP_DOCTOR D\r\n"
			 		+ "  ON R.DOCTOR_ID = D.DOCTOR_ID";
			 pst= 	con.prepareStatement(sql);
			 rs= pst.executeQuery();
			 
			 while( rs.next()) {
				 System.out.println( rs.getString(1));
				 String recordId = rs.getString(1);
				 String patientName = rs.getString(2);
				 String doctorName = rs.getString(3);
				 String diagnosisName = rs.getString(4);
				 String treatmentContent = rs.getString(5);
				 String prescriptionContent = rs.getString(6);
				 String treatmentDate = rs.getString(7);

				 Hospital hospital = new Hospital(recordId, patientName, doctorName, diagnosisName,
				         treatmentContent, prescriptionContent, treatmentDate);
				 list.add(hospital);			 
			 }			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//실행된 결과 	 
		 close( rs, pst, con);
		return list;		
	}
	
//	
//	//등록 
//	public void  insertMember(Acorn newAcorn) {		 		
//		Connection  con =dbcon();	
//		PreparedStatement pst= null;
//		
//		//sql
//		String sql=" insert  into  acorntbl(id, pw, name)  values(?,?,?) ";	
//		
//		try {
//			   pst =con.prepareStatement(sql);
//			
//			pst.setString(1,  newAcorn.getId()); //1 => 물음포에서 왼쪽부터
//			pst.setString(2,  newAcorn.getPw());
//			pst.setString(3,  newAcorn.getName());			
//			pst.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		close( pst, con);
//		
//		
//	}	
//	
	
	
	// 
//	public Acorn selectOne( String id) {		
//		//연결
//		Connection con  =dbcon();
//		PreparedStatement pst  =null;
//		ResultSet   rs  = null;
//		
//		
//		//sql
//		String  sql=" select * from acorntbl where id  =? ";		
//		Acorn acorn = null;
//		try {
//			 pst=con.prepareStatement(sql);
//			pst.setString(1, id);			
//			 rs = pst.executeQuery();			
//			
//			if( rs.next()) {
//				//id 존재하면
//				String id_tmp  = rs.getString(1);
//				String pw =  rs.getString(2);
//				String name = rs.getString(3);				
//				acorn = new Acorn( id_tmp , pw, name);
//			}			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		
//		close(rs, pst, con);
//		return acorn;		
//	}
	
		
	public void update( String id, String newpw) {
		Connection  con  =dbcon();		
		PreparedStatement pst = null;
		
		
		String sql= " update  acorntbl set  pw =?  where id= ? ";		
		try {
			 pst  =con.prepareStatement(sql);
			pst.setString(1, newpw);
			pst.setString(2, id);
			
			pst.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		close( pst, con);
	}		
	
	
	
	
	public void delete( String id ) {
		Connection  con  =dbcon();		
		String sql= " delete   acorntbl where  id= ? ";		
		PreparedStatement pst  = null;
		try {
			 pst  =con.prepareStatement(sql);		 
			pst.setString(1, id);
			
			pst.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		close( pst, con);
	}		
	//변경	
	public static void main(String[] args) {
		hospitalDAO  dao = new hospitalDAO();
		//dao.dbcon();
		ArrayList<Hospital> list  =dao.selectAll();
		for( Hospital acorn : list) {
			System.out.println( acorn);
		}
		//Acorn acorn = new Acorn("zzz","0000","고길동");
		//dao.insertMember(acorn);		
				
		//dao.update("sj", "4545");
	 
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
	
}
