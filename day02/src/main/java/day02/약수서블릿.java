package day02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/div")
public class 약수서블릿 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String su_ = req.getParameter("su");
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		
		int su;		
		if(su_ == null) {
			su =1;
		}else {
			su = Integer.parseInt(su_);
		}
		
		
		
		MyUtils m  = new MyUtils();
		String result  =m.getDivisor(su);
		
		
		
		
		PrintWriter out = resp.getWriter();		
		out.println(   su + "의 약수");		
		out.println( "<p>"+ result +"</p>");
		
		/*
		for(int i=1; i<=su; i++) {
			if(su % i == 0) {				
				out.println(i);
			}
		}		
		*/
	}
	
}
