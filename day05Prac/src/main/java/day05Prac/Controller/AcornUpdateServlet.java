package day05Prac.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day05Prac.Service.AcornService;
import day05Prac.dto.Acorn;

@WebServlet("/acorn/update")
public class AcornUpdateServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		int point = Integer.parseInt(req.getParameter("point"));
		
		//
		Acorn acorn = new Acorn();
		acorn.setId(id);
		acorn.setPw(pw);
		acorn.setPoint(point);
		
		AcornService service = new AcornService();
		service.modifyAcornStudent(acorn);
		
		
		//응답 view
		//재요청
		resp.sendRedirect("/day05Prac/acorn/list");
	}
}
