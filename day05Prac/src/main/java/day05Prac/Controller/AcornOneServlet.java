package day05Prac.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day05Prac.Service.AcornService;
import day05Prac.dto.Acorn;

@WebServlet("/acorn/detail")
public class AcornOneServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    String id = req.getParameter("id");

	    AcornService service = new AcornService();
	    Acorn acorn = service.getAcornStudentById(id);

	    req.setAttribute("acorn", acorn);

	    req.getRequestDispatcher("/WEB-INF/views/acorn/updateForm.jsp").forward(req, resp);
	}

}
