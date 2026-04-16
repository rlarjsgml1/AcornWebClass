package 학생.김민정;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/fighting2")
public class 화이팅메세지2  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		화이팅서비스 service = new 화이팅서비스();
		String message = service.getFighting();
		
		PrintWriter  out = resp.getWriter();
//		out.println("행운은 언제나 당신 편입니다.");
		out.println("<h2>" + message + "</h2>");
		
		
	}
	
}
