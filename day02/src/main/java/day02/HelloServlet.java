package day02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/hi")
public class HelloServlet  extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		
		// ^_____________^ hello servlet
		
		//응답하려면 출력스트임 얻어오기
		PrintWriter   out  =resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> ^_____________^ hello servlet  </h1>");
		out.println("</body>");
		out.println("</html>");
		 
	}

}
