package day03Prac.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/acornReg")
public class 에이콘등록servlet extends HttpServlet{
	
	//등록화면 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/acornForm.jsp").forward(req, resp);
	}
	
	//실제데이터베이스에 등록하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post");
		
		//데이터 꺼내기 전에 인코딩
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		
		Acorn acorn = new Acorn(id,pw,name);
		//Service에서 DAO를 통해서 데이터베이스 등록하기
		에이콘서비스 service = new 에이콘서비스();
		service.acornRegister(acorn);
		
		//응답
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/reg_ok.jsp").forward(req, resp);
	}
}
