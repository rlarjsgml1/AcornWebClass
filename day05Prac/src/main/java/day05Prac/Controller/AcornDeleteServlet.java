package day05Prac.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day05Prac.Service.AcornService;

@WebServlet("/acorn/delete")
public class AcornDeleteServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id"); //없으면 null
		AcornService service = new AcornService();
		boolean result = service.deleteAcornStudent(id);
		System.out.println(result);
		
		resp.sendRedirect("/day05Prac/acorn/list");
	}
}
