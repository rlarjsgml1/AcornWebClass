package day02;
 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/mymovieDB2")
public class MovieDBWithDAO extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        MovieDAO dao = new MovieDAO();
        ArrayList<Movie2> list = dao.selectAll();

        out.println("<html><body>");
        out.println("<h2>영화 목록</h2>");
        out.println("<table border='1'>");

        for (Movie2 m : list) {
            out.println("<tr>");
            out.println("<td>" + m.getTitle() + "</td>");
            out.println("<td>" + m.getGenre() + "</td>");
            out.println("<td>" + m.getDuration() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}