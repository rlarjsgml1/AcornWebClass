package movie;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//영화조회 서비스


@WebServlet("/movieAll")
public class MovieServlet  extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 
 	
		
		//모델 얻어오기
		MovieService service  =  new  MovieService();
		ArrayList<Movie> list  =service.getMoveListAll();
		
		
		//데이터 저장하기 
		req.setAttribute("list", list);
	 
		
		//jsp로 보내기  (jsp거쳐서 응답)
		req.getRequestDispatcher("/WEB-INF/views/movieList.jsp").forward(req, resp);
		
		 
		
	}
}
