package day07짝꿍실습;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/food3")
public class FoodThree extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String food1 = req.getParameter("food1");
		HttpSession session = req.getSession();
		session.setAttribute("food1", food1);
		req.getRequestDispatcher("/WEB-INF/views/food3.jsp").forward(req, resp);
	}
}
