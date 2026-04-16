package day01.Prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/double02")
public class 두배만들기서블릿2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		//클라이언트가 보낸 값 얻오오기 
		String  su_=  req.getParameter("su");  // su라는 이름을 키로 값을 얻어옴 
		//숫자로 변환해서 사용해야함 
		
		int su  = Integer.parseInt(su_);  // "5"  => 5   "125"  ->125
		
		int result  = su*2; 
		
		PrintWriter out  = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>result=</h2>");
		out.println(result);
		out.println("</body>");
	
		out.println("</html>");
		
		
		
		
	}
}
