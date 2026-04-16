package day01문제5개;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/sum")
public class 어떤수까지의합응답하기 extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();

        String numStr = request.getParameter("num");
        int num = Integer.parseInt(numStr);

        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }

        out.println("1부터 " + num + "까지의 합 : " + sum);

        out.close();
        //http://localhost:8080/day01/sum?num=10
    }
}