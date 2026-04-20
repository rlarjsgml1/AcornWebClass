package reg;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet1 extends HttpServlet {

    // GET → 회원가입 화면 보여주기
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register.jsp");
        dispatcher.forward(request, response);
    }

    // POST → 회원가입 처리
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender   = request.getParameter("gender");
        String role     = request.getParameter("role");
        String[] hobbies = request.getParameterValues("hobby"); // hobby_id 배열

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:testdb", "scott", "tiger");

            conn.setAutoCommit(false); // 트랜잭션 시작

            // 1.  시퀀스로 member_id 가져오기
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT member_seq.NEXTVAL FROM dual");
            int memberId = 0;
            if (rs.next()) {
                memberId = rs.getInt(1);
            }
            rs.close();
            stmt.close();

            // 2️⃣ 회원 정보 INSERT
            String sql = "INSERT INTO member2 (member_id, username, password, gender, role2) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, memberId);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setString(4, gender);
            pstmt.setString(5, role);
            pstmt.executeUpdate();
            pstmt.close();

            // 3️⃣ 다대다 취미 INSERT
            if (hobbies != null) {
                String hobbySql = "INSERT INTO member_hobby2 (member_id, hobby_id) VALUES (?, ?)";
                pstmt = conn.prepareStatement(hobbySql);
                for (String h : hobbies) {
                    pstmt.setInt(1, memberId);
                    pstmt.setInt(2, Integer.parseInt(h));
                    pstmt.executeUpdate();
                }
            }

            conn.commit();

            // 4️⃣ 결과 JSP로 이동
            request.setAttribute("username", username);
            request.setAttribute("gender", gender);
            request.setAttribute("role", role);
            request.setAttribute("hobbies", hobbies);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/registerSuccess.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
        	
            try { if (conn != null) conn.rollback(); } catch (Exception ee) {}
            throw new ServletException(e);
            
            
            
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception ignore) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception ignore) {}
            try { if (conn != null) conn.close(); } catch (Exception ignore) {}
        }
    }
}
