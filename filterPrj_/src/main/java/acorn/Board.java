package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//글쓰기

@WebServlet("/board.do")
public class Board  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		//로그인여부 체크 
		//주문정보가 보여지거나 아니면 로그인화면으로
	 
		
		/*
		HttpSession session = req.getSession(false); // 세션이 없으면 null 반환

		if (session != null) {
			
		    String id = (String) session.getAttribute("id");
		    if (id != null) {
		        // 로그인 상태일 때 → 모델 추가 후 게시판 페이지로 포워드
		        req.setAttribute("boardList", "list"); // 실제로는 게시글 목록을 전달
		        req.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(req, resp);
		        return;
		    }
		}

		// 로그인되어 있지 않으면 로그인 페이지로 리다이렉트
		resp.sendRedirect(req.getContextPath() + "/login");		
	 
	 
	 */
		  req.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		String title  =req.getParameter("title");
		String content  = req.getParameter("content");
		
		
		System.out.println( title);
		System.out.println(  content);
		
		
		
		resp.getWriter().print( title);
		resp.getWriter().print( content);
		
	}

}
