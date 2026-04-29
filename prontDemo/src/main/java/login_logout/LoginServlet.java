package login_logout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		// =======================
		// 로그인 테스트용으로 사용
		String testID = "test@naver.com";
		String testPW = "1111";
		// =======================
		
		String userID = req.getParameter("email");
		String userPW = req.getParameter("password");
		
		if(testID.equals(userID) && testPW.equals(userPW)) {
			req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		} else {
			// [실패]
			req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
		}
	}
}
