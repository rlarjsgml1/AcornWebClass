package day05Prac.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day05Prac.Service.AcornService;
import day05Prac.dto.Acorn;

@WebServlet("/acorn/reg")
public class AcornRegServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/acorn/reg.jsp").forward(req, resp);
	}

	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			req.setCharacterEncoding("utf-8");
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String pw = req.getParameter("pw");
			int point = Integer.parseInt(req.getParameter("point"));
			String birth = req.getParameter("birth");
			
			//String -> Date
			
			Date birthDate = null;
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				birthDate = df.parse(birth);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Acorn acorn = new Acorn();
			acorn.setId(id);
			acorn.setPw(pw);
			acorn.setName(name);
			acorn.setPoint(point);
			acorn.setBirth(birthDate);
			
			System.out.println(acorn);
			
			AcornService service = new AcornService();
			boolean result = service.registerAcornStudent(acorn);
			
			//ok.jsp
			//
//			req.getRequestDispatcher("WEB-INF/views/acorn/ok.jsp").forward(req, resp);
			
			//redirect, 재요청 서버 (재요청코드302) -> 브라우저 자동으로 재요청, 메인페이지 요청하기
			
			resp.sendRedirect("/day05Prac/home");
		}
}
