package 학생.여도현;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//영화정보 제공하기
//영화정보 제공하는 서비스
//영화정보 가져오는 로직을 분리 -자바  -MovieService
@WebServlet("/movie")
public class 클래스처리하기 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8"); // 서버 => 인코딩 utf-8 (실제 서버가 보낼때 인코딩 )
		resp.setContentType("text/html;charset=utf-8"); // 클라이언트 ( 웹브라우저 )에게 해석에 대한 정
		
		// 응답하기
		PrintWriter out = resp.getWriter();
		
		Movie m = new Movie("영화제목","영화감독",2026);
		
		out.println("<h2>제목: " + m.getTitle() + "</h2>");
        out.println("<h2>감독: " + m.getDirector() + "</h2>");
        out.println("<h2>연도: " + m.getYear() + "</h2>");
	}
}
