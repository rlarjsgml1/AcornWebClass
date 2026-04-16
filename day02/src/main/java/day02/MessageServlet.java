package day02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day02Prac.Teacher;


@WebServlet("/teacher")
public class MessageServlet  extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 resp.setCharacterEncoding("UTF-8");    
		 resp.setContentType("text/html;charset=utf-8");
		
		Teacher t  = new Teacher();		
		String str =t.getMessage();
		
		
		resp.getWriter().print( str);
		
	}

}
