package day01문제5개;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class 실습9번문제 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		
		 //이거는 나중에 하겠습니다 ~ 이미지까지 저장하고 하기가 귀찮기 때문에 하기가 싫어용 이거는 내 미래모습이 해줄겁니다 ㅅㄱ
		

	}

}
