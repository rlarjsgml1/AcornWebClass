package acorn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/errorHandle")
public class ErrorHandler  extends HttpServlet {	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
	PrintWriter out =resp.getWriter();
	Integer code=	(Integer) req.getAttribute("javax.servlet.error.status_code");
	String message=	(String) req.getAttribute("javax.servlet.error.message");
	String uri=	(String) req.getAttribute("javax.servlet.error.request_uri");
	
	
	 out.println( "<h2>서버오류입니다</h2>");
	 out.println( code);
	 out.println( message);
	 out.println( uri);
	 
	 //뷰로 포워드 	  
	 
	}

}
