package day01;

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
		out.println("</head>");                        
		out.println("<body>");
		out.println("<img  src=\"/day01/imgs/지맥주병이미.jpg\" >");    //절대위치, 프로젝트를   기준으로 경로 표시
		out.println("<img  src=\"a.webp\" alt=\"귀여운이미지\">"); 
		out.println("</body>");
		out.println("</html>");
	}

}
