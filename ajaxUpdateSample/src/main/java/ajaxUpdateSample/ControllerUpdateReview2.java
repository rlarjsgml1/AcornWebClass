package ajaxUpdateSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


@WebServlet("/update2")
public class ControllerUpdateReview2  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		PrintWriter out  = response.getWriter();
 		
	 
		String id  = request.getParameter("id");
		String content = request.getParameter("content");
		
		System.out.println( id);
		System.out.println( content);
				
		ReviewDTO review = new ReviewDTO( id, content);		
		System.out.println(  review);
		 
	  	
		
		
		//서비스객체의 매서드를 사용하여 데이터베이스에 변경
		out.print("1");
	}

}
