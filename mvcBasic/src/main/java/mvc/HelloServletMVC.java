package mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/himvc")
public class HelloServletMVC  extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		
		
		//1. 입력정보 추출
		
		//2. 모델: 데이터를 만드는 일
		
		//3. request 저장소에 모델 저장하기
		
		//4. 응답view 처리흐름을  jsp로  forword  시킨다.
		
		
		RequestDispatcher r= request.getRequestDispatcher("WEB-INF/views/helloView.jsp");
		r.forward(request, response);
		
		
	}

}
