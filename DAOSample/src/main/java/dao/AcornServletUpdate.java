package dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// /update          요청바디    id=mj&newpw=7777
@WebServlet("/update")
public class AcornServletUpdate  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		request.setCharacterEncoding("utf-8");
		
		String id  = request.getParameter("id");
		String newpw= request.getParameter("newpw");	
		
		//처리
		//model (서비스, dao)
		AcornService s = new AcornService();		 
		s.modifyMember( id,  newpw);
		
		
		// view 응답
		request.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(request, response);
		
	}
}
