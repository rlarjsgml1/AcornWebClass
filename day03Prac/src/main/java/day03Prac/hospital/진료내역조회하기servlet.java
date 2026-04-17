package day03Prac.hospital;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aa")
//이 Servlet은 진료내역 목록을 조회해서 jsp로 넘기는 역할
public class 진료내역조회하기servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		hospitalDAO dao = new hospitalDAO(); //객체를 만듬
		ArrayList<Hospital> list = dao.selectAll(); //DB에서 진료내역 전체를 조회해서 객체 여러 개를 ArrayList로 받아오는 것

		req.setAttribute("list", list); //jsp로 데이터를 넘기는 코드 

		req.getRequestDispatcher("/WEB-INF/views/hospitalList.jsp").forward(req, resp);
	}
}