package day01문제5개;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fighting2/random")
public class 실습8번문제 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		
		String[] message = {
				"술한잔하자",
				"맥주한잔하자",
				"소주한잔하자",
				"그냥찌그리자",
				"그냥먹자",
				"어쩌라고"
		};
		Random random = new Random();
		int index = random.nextInt(message.length);
		
		out.println("<p>" + message[index] + "</p>");

	}

}
