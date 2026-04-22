package day06Prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;

@WebServlet("/food2")
public class FoodServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Food food = new Food("후덕죽자장", 12000); // {키:값, 키:값}
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=utf-8");
		
		// 자바 객체 -> json 변환
		
		//
		//
		//
		
		PrintWriter out = resp.getWriter();
		// out.print("{\"name\":\"스파게티\", \"price\":12000}");
		// out.print("{\"name\":\""+food.getName()+"\", \"price\":"+food.getPrice()+"}");
		
//		JSONObject o = new JSONObject();
//		o.put("name", food.getName());
//		o.put("price", food.getPrice());
//		
//		out.print(o.toString());
		
		Gson gson = new Gson();
		String result = gson.toJson(food);
		out.print(result); // sysout과 헷갈리지 말 것. html쪽으로 스트림을 보내주는 것 뿐임
		
	}
	
}
