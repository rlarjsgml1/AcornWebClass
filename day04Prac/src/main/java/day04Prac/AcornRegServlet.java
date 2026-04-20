package day04Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿
//회원등록하기 요청을 처리하는 서블릿
//가입 화면보여주기 get
//가입 하기 post

@WebServlet("/reg")
public class AcornRegServlet extends HttpServlet{
	/* 오버라이드를 하지 않으면 메서드에는 아래와 같은 형식의 코드가 들어간다.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		System.out.println(method);
		
		if(method.equals("GET")) {
			doGet(req,resp);
		}
	}
	*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//등록하기 화면
		req.getRequestDispatcher("/WEB-INF/views/regForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 사용자가 보내 온 데이터 꺼내기, 확인하기 
		
		String id  =req.getParameter("id");
		String pw  =req.getParameter("pw");
		String name  =req.getParameter("name");
		int point   = Integer.parseInt(req.getParameter("point"));
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(point);
		
		Acorn acorn = new Acorn();
		acorn.setId(id);
		acorn.setPw(pw);
		acorn.setName(name);
		acorn.setPoint(point);
		
		AcornService service = new AcornService();
		service.registerMember(acorn);
		
		//등록하기 성공후 뷰 응답하기, 성공뷰
		//req.getRequestDispatcher("/WEB-INF/views/ok.jsp").forward(req, resp);
		
		//등록하기 성공 후 다른 요청을 하는 경우, redirect하기(브라우저에게 응답 재요청)
		//등록하기 성공 후 메인페이지 나오게 하기
		
		resp.sendRedirect("/day04Prac/home");
	}
	
}
