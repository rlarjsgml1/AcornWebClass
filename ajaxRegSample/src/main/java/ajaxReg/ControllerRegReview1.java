package ajaxReg;

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


@WebServlet("/reg1")
public class ControllerRegReview1  extends HttpServlet {
	
	
	
 
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		/*
		   //form 방식(application/x-www-form-urlencoded)으로 들어온 데이터는  요청바디를 직접읽어서 사용하는 경우
		   //직접 URL 디코딩을 해줘야 한다 (폼 전송 기본)
		   
		   
		   
		    req.setCharacterEncoding("utf-8");
			//클라이언트가 요청 body로 보낸 데이터 읽어오는 방법
		  	BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	        } 
	        System.out.println( sb.toString());
	        reader.close();

		 
		
			// URL 디코딩
			String decoded = java.net.URLDecoder.decode(sb.toString(), "UTF-8");
			System.out.println("요청 바디  " + decoded); 
	 
		
		*/
		
		 
		
		 //post는 기본이 application/x-www-form-urlencoded 형식임 
		 //서블릿싯컨테이너가 url디코딩 해 줌 
		 //getParameter로 데이터를 가져오는 경우 url디코딩은 신경쓸 필요없다
		req.setCharacterEncoding("utf-8"); 	
		
		
		String id = req.getParameter("id");
		String content = req.getParameter("content");		
		
		System.out.println( id);
		System.out.println( content);
		
		//서비스 객체를 통해서 데이터베이스 저장
		 
		resp.getWriter().print("ok");
		 
		
		 
	}
}
