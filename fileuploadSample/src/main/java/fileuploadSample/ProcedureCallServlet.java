package fileuploadSample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/callProc")
public class ProcedureCallServlet extends HttpServlet {
     

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            //   1. JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //   2. DB 연결
            String url = "jdbc:oracle:thin:@localhost:1521:testdb"; // 환경에 맞게 수정
            String user = "scott";     // 계정명
            String password = "tiger"; // 비밀번호
            conn = DriverManager.getConnection(url, user, password);

            //   3. 프로시저 호출 준비
            String sql = "{ call emp_avg_ANNL_PERF(?) }";
            cstmt = conn.prepareCall(sql);

            //   4. OUT 파라미터 등록
            cstmt.registerOutParameter(1, Types.NUMERIC);

            //   5. 실행
            cstmt.execute();

            //  6. OUT 파라미터 값 가져오기
            double avgSalary = cstmt.getDouble(1);

            out.println("<h2>평균 ANNL_PERF: " + avgSalary + "</h2>");

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>오류 발생: " + e.getMessage() + "</h3>");
        } finally {
            try { if (cstmt != null) cstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}