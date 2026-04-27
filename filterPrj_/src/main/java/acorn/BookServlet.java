package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//예약하기    => 로그인후 에 사용가능하도록 하겠다 
@WebServlet("/book.acorn")
public class BookServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		 
		 
		
		//로그인 유무 확인 후 처리 
		
		/*
		//세션 확인 		
		HttpSession session  = req.getSession(false);		
		
		if( session != null) { 
		
			String id  = (String)session.getAttribute("id");
			
			//로그인한 경우
			if( id !=null) {
				
				//예약화면 응답하기
				req.getRequestDispatcher("/WEB-INF/views/book.jsp").forward(req, resp);		
				return;
				
			}
		
		}
		 
			
			//로그인서비스가 요청될 수 있도록  redirect
		String path  = req.getContextPath();     //filterPrj_   =>프로젝트명
		System.out.println(path);
		resp.sendRedirect(path+"/login" );   ///filterPrj_/loign   => get요청있는것만 가능하다 
		
	 */
	 
		
		 req.getRequestDispatcher("WEB-INF/views/book.jsp").forward(req, resp);
		
		
	}
}
