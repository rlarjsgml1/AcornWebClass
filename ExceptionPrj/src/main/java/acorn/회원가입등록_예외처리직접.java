package acorn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 
 * 
 * web.xml에  작성하는 방법
 * 
    <!-- 데이터베이스 관련 예외 처리 -->
    <error-page>
        <exception-type>java.sql.SQLException</exception-type>
        <location>/databaseError</location>
    </error-page>

    <!-- 서버 오류 500 코드 발생 시 공통 오류 페이지 처리 -->
    <error-page>
        <error-code>500</error-code>
        <location>/databaseError</location>
    </error-page> 
    
    
   
 */



/*
 *  예외처리방법
 *  1. 직접 try~ catch 
 *  2. web.xml  오류등록 
 *    ( 에러코드,  에러타입 ) 
 * 
 */

@WebServlet("/acornReg")
public class 회원가입등록_예외처리직접 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	 
		
		req.getRequestDispatcher("WEB-INF/views/joinus.jsp").forward(req, resp);
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {				
	 
		 
		req.setCharacterEncoding("UTF-8");			
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String id  =req.getParameter("id");
		String pw = req.getParameter("pw");
		String name  = req.getParameter("name");
	 
		
		Customer c = new Customer( id, pw, name);		
		AcornService s = new AcornService();     // dao에서 예외다시 일으키기로 예외가 넘어 와야 한다 , 예외를 다 잡으면 안됨
		try {
			
			
			s.registerCustomer(c);   	//회원가입 성공		
			req.getRequestDispatcher("WEB-INF/views/regOk.jsp").forward(req, resp);  // 성공페이지  또는 리다이렉트 하기
			
		} catch (SQLException e) {
			 
			//회원가입실패 , 데이터베이스 오류
		//	e.printStackTrace();
			req.getRequestDispatcher("WEB-INF/views/dberr.jsp").forward(req, resp);
		} 	
		
		
	}
	
}
