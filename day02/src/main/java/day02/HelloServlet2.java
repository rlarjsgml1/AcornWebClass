package day02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// hi2?num=3
@WebServlet("/hi2")
public class HelloServlet2  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// 서버는 클라이언트가 보낸 값을 얻어 올 수 있다.
		String num_= request.getParameter("num");
		
		int num;		
		if( num_ == null) {  
			num=1;		
		}
		else { 
			num =  Integer.parseInt(num_);	
		}
		
		//num=2   => hello servlet  hello servlet 
		
		String result ="";
		for( int i=1; i<= num; i++) {
			result  += "<h2> hello servlet ^_^ </h2>";
		}
		
		
		//
		PrintWriter  out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println(result);
		out.println("</body>");	 
		out.println("</html>");
		
		
		
	}
}
