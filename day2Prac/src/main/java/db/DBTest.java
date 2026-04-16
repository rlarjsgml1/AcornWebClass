package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "scott";
		String password = "tiger";

		// 1.오라클 드라이버 로딩
		Class.forName(driver);

		// 2.데이터베이스 연결
		Connection con = DriverManager.getConnection(url, user, password);

		// 3.statement 열어오기
		Statement st = con.createStatement();

		// 4.필요한 sql 작성하기
		String sql = "select * from movie";

		// 5.최종적으로 실행하고 결과가져오기
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) { // 데이터가 있으면 true, 없으면 false
			System.out.println(rs.getString(1)); // 컬럼의 순번
			System.out.println(rs.getString(2)); // 컬럼의 순번
		}
		//정리하기
		rs.close();
		st.close();
		con.close();
	}
}
