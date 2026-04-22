package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;

@WebServlet("/food2")
public class FoodServlet2  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
	 
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");	
		
		Food food = new Food("볶음밥","6000");  // 자바객체    ->  json 객체로 변환한 후 응답 
		                                      //              자바스크립트 객체표기법{ 키:값, 키:값}
		
		
		//1.  json라이브러리
		
		JSONObject  o= new JSONObject();
		o.put("name", food.getName());
		o.put("price", food.getPrice());	
		
		
		// resp.getWriter().println( o); 
		
		
		//2. 직접 json 응답하기
	 	 //resp.getWriter().println( "{\"name\":\"볶음밥\" , \"price\": \"6000\"}" );
		
		
		//3. Gson json라이브러리
		Gson gson =new Gson();
		String jsonData = gson.toJson(food);		
		  resp.getWriter().println( jsonData);
		
	}

}
