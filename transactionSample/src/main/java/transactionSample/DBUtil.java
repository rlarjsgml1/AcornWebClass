package transactionSample;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    // Oracle DB 연결 정보
	
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:testdb"; // XE: Oracle Express Edition SID
    private static final String USER = "system";    // Oracle 계정
    private static final String PASSWORD = "1234"; // 계정 비밀번호

    
    public static Connection dbcon() throws Exception {
        // 1. Oracle JDBC 드라이버 로드
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 2. 커넥션 생성
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        // 3. 트랜잭션 수동 관리
        conn.setAutoCommit(false);

        return conn;
    }
}
