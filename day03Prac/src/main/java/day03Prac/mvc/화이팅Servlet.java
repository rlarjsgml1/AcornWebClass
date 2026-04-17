package day03Prac.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvcfighting")
public class 화이팅Servlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//사용자입력 가져오기
		
		//모델(화이팅 메시지)
		화이팅서비스 service = new 화이팅서비스();
		String data = service.getMessage();
		
		//저장소 request(req)를 저장소로 사용함 !!!
		//요청 -> 응답될 때 까지 살아있는 저장소
		//저장,꺼내오기
		req.setAttribute("data", data); //key, value (key를 원하는 값으로 정한다) 
		
		//뷰(화면 뷰)
		//만들어 놓은 뷰로 forward
		req.getRequestDispatcher("/WEB-INF/views/fightingView.jsp").forward(req, resp);
	}
}
