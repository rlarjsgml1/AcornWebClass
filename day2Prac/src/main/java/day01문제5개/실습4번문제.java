package day01문제5개;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/movie22")
public class 실습4번문제 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();

        Movie movie = new Movie("인터스텔라", "크리스토퍼 놀란", "SF", 169);

        out.println("<html>");
        out.println("<head><title>영화 정보</title></head>");
        out.println("<body>");
        out.println("<h2>영화 정보</h2>");
        out.println("<p>제목 : " + movie.getTitle() + "</p>");
        out.println("<p>감독 : " + movie.getDirector() + "</p>");
        out.println("<p>장르 : " + movie.getGenre() + "</p>");
        out.println("<p>상영시간 : " + movie.getRunningTime() + "분</p>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}