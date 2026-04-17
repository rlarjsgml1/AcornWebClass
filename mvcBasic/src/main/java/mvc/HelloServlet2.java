package mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi2")
public class HelloServlet2  extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");		
		PrintWriter  out =response.getWriter();	
		//응답할 데이터 (내용)		
		
		String name = request.getParameter("name");
		
		//view 응답화면
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println( "<h2>"+  name + "hi </h2>" );	
		out.println("</body>");
		out.println("</html>"); 
		
		
	}

}
