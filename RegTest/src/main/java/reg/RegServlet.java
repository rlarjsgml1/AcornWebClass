package reg;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reg")
public class RegServlet  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		req.getRequestDispatcher("/WEB-INF/views/reg.jsp").forward(req, resp);
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		 
		  // POST 요청에서 값 꺼내오기
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");  // "M" 또는 "F"
        String role = request.getParameter("role");      // "USER", "ADMIN", "SELLER"
        
        String[] hobbies = request.getParameterValues("hobby");

        if (hobbies != null) {
            for (String h : hobbies) {
                System.out.println("선택한 취미: " + h);
            }
        } else {
            System.out.println("취미 선택 없음");
        }


        // 응답 테스트 (DB 저장 대신 콘솔/화면 확인)
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("<h2>회원가입 결과</h2>");
        response.getWriter().println("아이디: " + username + "<br>");
        response.getWriter().println("비밀번호: " + password + "<br>");
        response.getWriter().println("성별: " + gender + "<br>");
        response.getWriter().println("회원유형: " + role + "<br>");
        response.getWriter().println("회원 취미: "  +String.join(",", hobbies));
        
        
		
	}

}
