package day01문제5개;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sum10")
public class 합응답1부터10까지 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();

        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }

        out.println("<h3>1~10까지의 합</h3>");
        out.println("합계 : " + sum);

        out.close();
    }
}