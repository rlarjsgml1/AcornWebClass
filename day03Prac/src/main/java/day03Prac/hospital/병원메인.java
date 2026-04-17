package day03Prac.hospital;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//main.jsp시작화면의 보내주는 Servlet 
@WebServlet("/main") // 주소매핑
public class 병원메인 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doGet : get 방식 요청이 들어왔을 때 실행되는 메서드 (<a href="">) Get방식
		req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
		//main.jsp에게 화면을 보여줘라 그리라고 일을 넘겨라하는 코드

	}
}
