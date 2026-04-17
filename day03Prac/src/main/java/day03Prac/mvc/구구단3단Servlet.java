package day03Prac.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//3단 정보 제공하는 서비스

@WebServlet("/dan3mvc")
public class 구구단3단Servlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		resp.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8");  
		
		PrintWriter out = resp.getWriter();  
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		//3단 제공하기를 별도의 자바파일로 분리하기 
		for(int i = 1; i <= 9; i++) {
			out.println("3 X " + i + " = " + 3 * i + "<br>");
		}
		out.println("</body>");
		out.println("</html>");
		*/
		//3단 정보 만들기
		구구단서비스 service = new 구구단서비스();
		String[] dan3 = service.getDan3();
//		3단정보 심기 -모델
		req.setAttribute("aaa", dan3);
		req.getRequestDispatcher("/WEB-INF/views/gugudan.jsp").forward(req, resp);
	}
}
