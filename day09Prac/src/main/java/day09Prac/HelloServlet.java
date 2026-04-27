package day09Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1.try~catch
		//2.에러모드, exception -type 예외page가 응답되게 하기 
		
		String str = req.getParameter("str");
		HelloService service = new HelloService();
		
		int cnt = 0;
		try {
			cnt = service.getLength(str); //정상적인 경우
			req.setAttribute("cnt", cnt);
			req.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); //문제가 있는 경우
			req.getRequestDispatcher("/WEB-INF/views/helloErr.jsp").forward(req, resp);
		}
		
//		System.out.println(cnt);
		
		//정상적인 경우
		//에러가 발생하는 경우 에러뷰
	}
}
