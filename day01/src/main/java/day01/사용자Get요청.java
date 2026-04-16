package day01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloGet")
public class 사용자Get요청   extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		
		//클라이언트 요청 읽어오기
		String data  =req.getParameter("data");
		System.out.println();
		
		
		//클라이언트에게 응답 보내기
		resp.getWriter().print( data);
		
	}
	
	

}
