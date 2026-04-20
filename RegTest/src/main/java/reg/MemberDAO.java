package reg;

import java.sql.*;

public class MemberDAO {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:testdb";
    private static final String USER = "scott";
    private static final String PASSWORD = "tiger";
    
    

    // Connection 생성 메서드 – 클래스 로드 포함
    public Connection getConnection() throws SQLException {
    	
    	Connection con =null;
        try {
            // Oracle JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con  =DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Oracle JDBC Driver 로딩 실패", e);
        }
        return con;
    }
    
    

    // 회원가입
    public int insertMember(String name, String pwd, String gender, String role, String[] hobbies) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int memberId = 0;

        try {
            conn = getConnection();
            
            conn.setAutoCommit(false); // 자동커밋 해제 
            

            // 시퀀스로 member_id 가져오기
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT member_seq.NEXTVAL FROM dual");
            if (rs.next()) memberId = rs.getInt(1);
            rs.close();
            stmt.close();

            // 회원 정보 INSERT
            String sql = "INSERT INTO member2 (member_id, username, password, gender, role2) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, memberId);
            pstmt.setString(2, name);
            pstmt.setString(3, pwd);
            pstmt.setString(4, gender);
            pstmt.setString(5, role);
            pstmt.executeUpdate();
            pstmt.close();

            // 다대다 취미 INSERT
            if (hobbies != null) {
                String hobbySql = "INSERT INTO member_hobby2 (member_id, hobby_id) VALUES (?, ?)";
                pstmt = conn.prepareStatement(hobbySql);
                for (String h : hobbies) {
                    pstmt.setInt(1, memberId);
                    pstmt.setInt(2, Integer.parseInt(h));
                    pstmt.executeUpdate();
                }
            }

            //모두 수행되었을 때 커밋하기    위에서 예외상황이 발생한다면 !!!   catch  블럭에서 롤백하기 
            conn.commit();

        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }

        return memberId;
    }
}
