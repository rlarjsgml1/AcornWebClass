package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/order.do")
public class Order  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		//로그인여부 체크 
		//주문정보가 보여지거나 아니면 로그인화면으로
	 /*
		HttpSession  session  = req.getSession(false);
		
		if( session != null ) {
		
			String id  = (String)session.getAttribute("id");		
			 
			if( id !=null) {
				// model, 주문목록 
				req.getRequestDispatcher("/WEB-INF/views/order.jsp").forward(req, resp);
				return;
			}  
		}
		resp.sendRedirect("/filterPrj_/login");
		
		*/ 
	    req.getRequestDispatcher("WEB-INF/views/order.jsp").forward(req, resp);
		
	}

}
