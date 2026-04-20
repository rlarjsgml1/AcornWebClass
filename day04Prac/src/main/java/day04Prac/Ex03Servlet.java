package day04Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex03")
public class Ex03Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Ex03Service service = new Ex03Service();
		Score score = service.getScore();

		req.setAttribute("data", score);

		req.getRequestDispatcher("/WEB-INF/views/ex03View.jsp").forward(req, resp);
	}
}