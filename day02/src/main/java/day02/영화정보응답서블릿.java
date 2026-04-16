package day02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/movie")
public class 영화정보응답서블릿  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//영화정보   응답		
		
		Movie m = new Movie("베터랑2" ,"1시간58분" ,"정해인,황정민" );
		
		
		PrintWriter  out = resp.getWriter();
		out.print( m);    // m.toString()
		
		
		
	}
	
}
