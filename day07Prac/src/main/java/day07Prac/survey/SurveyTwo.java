package day07Prac.survey;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/survey2")
public class SurveyTwo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String animal = req.getParameter("animal"); //이 정보를 하나의 사용자가 사용할 수 잇는 저장소 session 이용하기
		HttpSession session =  req.getSession();
		
		session.setAttribute("animal", animal);
		
		req.getRequestDispatcher("/WEB-INF/views/survey2.jsp").forward(req, resp);
	}
}
