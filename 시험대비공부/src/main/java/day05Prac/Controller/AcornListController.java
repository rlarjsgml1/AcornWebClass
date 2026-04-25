package day05Prac.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day05Prac.Service.AcornService;
import day05Prac.dto.Acorn;

@WebServlet("/acorn/list")
public class AcornListController extends HttpServlet {

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		AcornService service = new AcornService();
//		ArrayList<Acorn> list = service.getMembers();
//
//		req.setAttribute("list", list);
//		req.getRequestDispatcher("/WEB-INF/views/acorn/list.jsp").forward(req, resp);
//		
//	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		AcornService service = new AcornService();
//		ArrayList<Acorn> list = service.getMembers();
//		
//		req.setAttribute("list", list);
//		req.getRequestDispatcher("/WEB-INF/views/acorn/list.jsp").forward(req, resp);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AcornService service = new AcornService();
		ArrayList<Acorn> list = service.getMembers();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/acorn/list.jsp").forward(req, resp);
	}
	
	
	
	
	
	
	
}