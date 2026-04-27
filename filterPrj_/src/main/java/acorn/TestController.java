package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test")
public class TestController  extends HttpServlet {

	 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
	 
		///
		// 로그인 유뮤 확인 후  원래뷰를 보여주거나 아니면 로그인 하도록 
		
		/*
		String path = req.getContextPath();
		//애플리케이션 이름 얻어옴 
		// 하나의 애플리케이션을   context라고 함 
		
		
		HttpSession session  = req.getSession(false);		
		
		if(session != null) { 
			String  id  =  (String )session.getAttribute("id");
			
			if(  id != null) {
				req.getRequestDispatcher("WEB-INF/views/test.jsp").forward(req, resp);
				
			} 
		
		}
			
		 resp.sendRedirect(path +"/login");
		 
		*/
		
		req.getRequestDispatcher("WEB-INF/views/test.jsp").forward(req, resp);
		
	
	}
}
