package day01.Prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

/*
 * 1.httpServlet 상속받기
 * 2.약속된 매서드 service 오버라이드
 * 3.url-pattern 매핑하기
 */

//인사하기 사용자 요청 -> 예쁘게 인사하기
@WebServlet("/hello2")
public class Helloservlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 내 요청에 대한 처리하기
		//응답정보 데이터Contest-type : tet/html(기본), text/plain, application/json
		//응답정보 인코딩방식 : 한글인코딩 utf-8
		//!! 주의사항 반드시 출력스트림을 얻어오기 전에 설정해야 한다.
		response.setCharacterEncoding("utf-8"); // 서버 -> 인코딩 utf-8 ( 실제 서버가 보낼때 인코딩)
		response.setContentType("text/html;charset=utf-8"); // 클라이언트(웹브라우저)에게 해석에 대한 정보
		LocalDateTime now = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String result = now.format(formatter);

		// 응답하기
		PrintWriter out = response.getWriter();
		LocalDate today = LocalDate.now();
		out.println("<html>");
		out.println("<head>");
		out.println("<//head>");
		out.println("<body>");
		out.println("<h2> hi servlet !! 2026-04-15 </h2>");
		
//		out.write();
	}
}
