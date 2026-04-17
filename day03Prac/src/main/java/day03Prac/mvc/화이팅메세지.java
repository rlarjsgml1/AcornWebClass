package day03Prac.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿 한개로 작성
//MVC
//	Controller - 서블릿
//	View - jsp
//	Model -Service

@WebServlet("/fighting")
public class 화이팅메세지  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");   // text/plain  , text/html , application/json
		//resp.setContentType("text/plain;charset=utf-8");   // text/plain  , text/html , application/json
		
		
		PrintWriter  out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("행운은 언제나 당신 편입니다.");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}
	
}
