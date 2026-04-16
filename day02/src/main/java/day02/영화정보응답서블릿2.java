package day02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/movie2")
public class 영화정보응답서블릿2  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		Movie m = new Movie("베터랑2" ,"1시간58분" ,"정해인,황정민" );
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8"); 

		PrintWriter   out =resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("table{  border:1px solid black; }");
		out.println("td{  border:1px solid black; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>영화제목</td>");
		out.println("<td>상영시간</td>");
		out.println("<td>배우</td>");		 
		out.println("</tr");
		out.println("<tr>");
		out.println("<td>" + m.getName() +"</td>");
		out.println("<td>" + m.getRunningtime()+"</td>");
		out.println("<td>" +m.getActor() +"</td>");		 
		out.println("</tr");		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}
}
