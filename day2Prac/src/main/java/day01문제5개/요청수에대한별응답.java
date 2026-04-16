package day01문제5개;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cnt")
public class 요청수에대한별응답 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();

        String cntStr = request.getParameter("cnt");
        int cnt = Integer.parseInt(cntStr);

        for (int i = 1; i <= cnt; i++) {
            out.print("★");
        }

        out.close();
    }

}
