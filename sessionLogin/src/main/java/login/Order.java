package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/order")
public class Order  extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//1.세션 확인 하기    
		//세션이 없다면 로그인이 안된상태로 로그인 화면으로 이동하게 함 
		HttpSession session = request.getSession();
		String id  = (String) session.getAttribute("id");
		
		
		//2.세션에 로그인정보가 있다면
		if( id != null) {		
			// 해당id의 주문정보 가져오기(dao사용)			
			//주문정보리스트 모델 심기
			request.getRequestDispatcher("/WEB-INF/views/order.jsp").forward(request, response);			
		} //세션에 로그인정보가 없다면
		else {
			
			//로그인처리하는 서블릿 (서비스) 리다이랙트  
			response.sendRedirect("/sessionLogin/login");
		}
		
		
	}
}
