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


@WebServlet("/reg2")
public class ControllerRegReview2  extends HttpServlet {
	
 
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter out  = response.getWriter(); 
  
	 
		    request.setCharacterEncoding("utf-8");
			//클라이언트가 body로 보낸 데이터 읽어오는 방법
		  	BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	        }
	        
	        	        
	        
	        System.out.println( sb.toString());
	        reader.close();

	        // 읽은 본문을 JSON으로 파싱
	        JSONObject jsonBody = new JSONObject(sb.toString());
	        
	        // id와 content 키에 대한 값 추출
	        String id = jsonBody.getString("id");
	        String content = jsonBody.getString("content");
	        
	        
	        System.out.println("Received id: " + id);
	        System.out.println("Received content: " + content); 
		
		
			ReviewDTO review = new ReviewDTO( id, content);			
			System.out.println(  review);
			
			 
			 	
			//서비스객체를 통해서 데이터베이스에 반영
			 response.getWriter().println("ok");
			 
		
	}
}
