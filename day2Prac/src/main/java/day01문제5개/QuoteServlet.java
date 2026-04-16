package day01문제5개;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quote")
public class QuoteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();

        String[] quotes = {
            "성공은 포기하지 않는 사람의 것이다.",
            "오늘의 노력이 내일의 실력이 된다.",
            "천천히 가도 멈추지 않으면 된다."
        };

        int index = (int)(Math.random() * quotes.length);

        out.println("<h2>오늘의 명언</h2>");
        out.println("<p>" + quotes[index] + "</p>");

        out.close();
    }
}