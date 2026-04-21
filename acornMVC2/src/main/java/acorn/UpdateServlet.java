package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/acorn/update")
public class UpdateServlet   extends HttpServlet{

	 
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 				
		String id  =request.getParameter("id");
		String pw = request.getParameter("pw");
				
		System.out.println( id);
		System.out.println( pw);
		
		AcornService service = new AcornService();
		service.modifyAcornStudent(id, pw);		
		
		//
		request.getRequestDispatcher("/WEB-INF/views/updateok.jsp").forward(request, response);
		
	}
	
}
