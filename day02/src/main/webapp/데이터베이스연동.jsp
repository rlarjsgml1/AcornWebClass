<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    Connection con=null; 
	Statement st = null;
	ResultSet rs = null;
	try{ String driver = "oracle.jdbc.driver.OracleDriver" ;
	
		String url="jdbc:oracle:thin:@localhost:1521:testdb";
		String user="scott";
		String password="tiger";
		
		 //1. 오라클드라이버 로딩
		Class.forName(driver); //2. 데이터베이스 연결
		con= DriverManager.getConnection(url, user, password); //3. statement 얻어오기
		st = con.createStatement();
		 //4. 필요한 sql 작성
		String sql ="select * from member_tbl_11"; //5. 최종적으로 실행
		rs = st.executeQuery( sql) ; 
		 //6. 가져온 쿼리 결과를 화면에 출력하기
		while( rs.next() ) {
			out.print(rs.getString(1)); // out은 브라우저에 출력을 의미함
			out.print(rs.getString(2));
		} 
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{ //자원의 반납 
		if( rs!= null) rs.close();
		if( st != null) st.close();
		if( con != null) con.close();
	}
%>
</body>
</html>