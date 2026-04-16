package day01문제5개;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/divisor5")
public class 실습6번문제 extends HttpServlet{
@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();
        String numStr = request.getParameter("num");
        int num = Integer.parseInt(numStr);
        
        for(int i = 1; i<=num; i++) {
        	if(num%i==0) {
        		out.println(i+" ");
        	}
        }
        out.close();
	}

}
