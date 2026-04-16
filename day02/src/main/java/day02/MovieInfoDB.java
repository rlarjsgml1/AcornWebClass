package day02;

 

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mymovieDB")
public class MovieInfoDB extends HttpServlet {
    
   
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        resp.setCharacterEncoding("utf-8");
	        resp.setContentType("text/html;charset=utf-8");

        	PrintWriter out = resp.getWriter();
            String URL = "jdbc:oracle:thin:@localhost:1521:testdb"; // 오라클 XE 기준
            String USER = "scott";
            String PASSWORD = "tiger";

        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "SELECT *   FROM MOVIE";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("table { border:1px solid black; border-collapse: collapse; }");
            out.println("td, th { border:1px solid black; padding: 8px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>영화 목록</h2>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>영화제목</th>");
            out.println("<th>장르</th>");
            out.println("<th>상영시간</th>");		 
            out.println("</tr>");

            while (rs.next()) {
                String title = rs.getString(2);
                String genre = rs.getString(3);
                String runningTime = rs.getString(4);

                out.println("<tr>");
                out.println("<td>" + title + "</td>");
                out.println("<td>" + genre + "</td>");
                out.println("<td>" + runningTime + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

            // 리소스 정리
            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            out.println("JDBC 드라이버를 찾을 수 없습니다: " + e.getMessage());
        } catch (SQLException e) {
            out.println("DB 연결 중 오류 발생: " + e.getMessage());
        }
    }
}
