package day01문제5개;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dan")
public class 실습3번문제 extends HttpServlet {
	//실행하고 밑에 주소 넣고 해보기 
	//http://localhost:8080/day2Prac/dan?num=2 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();
        String numStr = request.getParameter("num");
        int num = Integer.parseInt(numStr);
        for(int i =1; i<=9; i++) {
        	out.println("<p>" + num + "x" + i + "=" + (i*num) + "</p>");
        }
		out.close();
	}

}
