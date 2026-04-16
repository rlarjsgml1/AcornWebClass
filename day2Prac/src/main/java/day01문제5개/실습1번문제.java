package day01문제5개;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class 실습1번문제 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		
		String num1Str = request.getParameter("num1");
		String num2Str = request.getParameter("num2");
		
		int num1 = Integer.parseInt(num1Str);
		int num2 = Integer.parseInt(num2Str);
		
		out.println(num1 + num2 + "=" + (num1 + num2));
		out.println(num1 + num2 + "=" + (num1 - num2));
		out.println(num1 + num2 + "=" + (num1 * num2));
		out.println(num1 + num2 + "=" + (num1 / num2));
		

		out.close();
	}
}