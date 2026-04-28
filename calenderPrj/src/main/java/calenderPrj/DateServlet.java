package calenderPrj;


import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/date")
public class DateServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
	        rd.forward(req, resp);
	}
	
	
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        // 한글이나 특수문자 깨짐 방지 (폼 전송 시 필수)
	        req.setCharacterEncoding("UTF-8");

	        //  넘어온 파라미터 받기
	        String startDate = req.getParameter("startDate");
	        String endDate = req.getParameter("endDate");

	        System.out.println("시작일: " + startDate);
	        System.out.println("종료일: " + endDate);

	        //   전달할 데이터 세팅
	        req.setAttribute("startDate", startDate);
	        req.setAttribute("endDate", endDate);

	        // 결과 페이지로 포워드
	        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/result.jsp");
	        rd.forward(req, resp);
	    }
	 
}