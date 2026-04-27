package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


//get, post ==>오류가 발생하면 모두 처리할 수 잇도록 service 메서드 활용
@WebServlet("/errorHandle3")
public class ErrorHandle3 extends HttpServlet{
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/err3.jsp").forward(req, res);
	}

}
