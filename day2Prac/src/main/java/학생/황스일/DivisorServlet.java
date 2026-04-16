package 학생.황스일;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/divisor")
public class DivisorServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            int num = Integer.parseInt(req.getParameter("num"));
            out.println("<h1>" + num + "의 약수</h1>");
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    out.print(i + " ");
                }
            }
        } catch (NumberFormatException | NullPointerException e) {
            out.println("잘못된 입력입니다. 'num' 파라미터에 숫자를 입력해주세요. 예: /divisor?num=10");
        }
    }
}