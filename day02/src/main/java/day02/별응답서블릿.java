package day02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. HttpServlet 상속받기 
//2. 서블릿으로 등록하기   @Webservlet( "/hi")
//3. service 매서드를  자신의 요청에 맞게 응답할 수 있도록 재정의 해야 한다 
//4. 출력스트림을 통해서 만든응답내용를 보내야 한다 


@WebServlet("/starEx")
public class 별응답서블릿   extends HttpServlet {
	
 @Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	 response.setCharacterEncoding("UTF-8");    
	 response.setContentType("text/html;charset=utf-8");
	 //response.setContentType("text/plain;charset=utf-8");
	 //출력스트림을 얻어오기전에 설정해야 한다 . !!
	 
	 PrintWriter  out  =  response.getWriter();
	 out.println("★★★★★★"); 
	 
}
}
