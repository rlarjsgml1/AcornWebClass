package day07짝꿍실습;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/food2")
public class FoodTwo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String food = req.getParameter("food");
		HttpSession session = req.getSession();
		session.setAttribute("food", food);
		req.getRequestDispatcher("/WEB-INF/views/food2.jsp").forward(req, resp);
	}

}
