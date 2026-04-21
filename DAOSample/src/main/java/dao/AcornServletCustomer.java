package dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class AcornServletCustomer  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		//사용자로부터 정보 꺼내오기
		String id =request.getParameter("id");		
		//모델
		  AcornService s = new AcornService();
		//		
		Customer c= s.getMember(id);		
		  
		//모델심기
		request.setAttribute("customer", c);
		request.getRequestDispatcher("/WEB-INF/views/customer.jsp").forward(request, response);
		 
		
	}
}
