package day01.Prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/double01")
public class 두배만들기서블릿 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		int su =5;
		int result  = 5*2;
		
		
		//응답하기
		PrintWriter   out  = resp.getWriter();		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println( result);
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
