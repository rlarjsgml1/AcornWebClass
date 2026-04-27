package acorn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 
 *  NullpointerException 발생에 대해서 
 *  예외처리할 수 있도록 
 *  
 *  서버의 
 *  web.xml에 등록하기 
 *  
 *  <error-page>
	   <exception-type>java.lang.NullPointerException</exception-type>
	   <location>/errorHandle</location>
	</error-page>
	
	  
 * 
 */


@WebServlet("/ex1")
public class 예외발생하는서블릿  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int len=0;
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();	 
		String str = req.getParameter("str");
		len= str.length();		 	
		out.println("length=>"+len);
		out.println("mission clear");		
		out.close();
	}
	
}
