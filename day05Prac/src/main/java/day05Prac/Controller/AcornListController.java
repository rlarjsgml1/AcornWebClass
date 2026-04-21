package day05Prac.Controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day05Prac.dto.Acorn;
import day05Prac.Service.AcornService;


// 전체조회

@WebServlet("/acorn/list")
public class AcornListController  extends HttpServlet{  // C

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		
		//Model 
		AcornService service = new AcornService();
		ArrayList<Acorn>   list  = service.getMembers();
		
		//Model  심기  - 저장소 사용  ( request )      ,(  session  ),  applicationContext  , pageContext , 쿠기)
			
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/acorn/list.jsp").forward(req, resp);  //V
	}
}
