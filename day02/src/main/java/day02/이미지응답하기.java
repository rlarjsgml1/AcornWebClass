package day02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cute")
public class 이미지응답하기  extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter  out  =resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");                           // <img src="/day02/a.png" /> 
		out.println("<body>");
		out.println("<img  src=\"/day02/a.png\" />");    // "<img src=\"/day02/a.png\" />"
		out.println("</body>");
		out.println("</html>");
	}

}
