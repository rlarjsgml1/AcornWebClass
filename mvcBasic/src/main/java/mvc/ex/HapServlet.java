package mvc.ex;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/hapEx")
public class HapServlet  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		PrintWriter   out = response.getWriter();	
		
		// 두  수 꺼내기 (입력) 
		
		String su1_  = request.getParameter("su1");
		String su2_  = request.getParameter("su2");
		
		int su1 = Integer.parseInt(su1_);
		int su2  = Integer.parseInt(su2_);		
		
		
		// 합 (처리)
		
		int total = su1+ su2;
		
		
		//응답 (출력)		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>" + total + "</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
