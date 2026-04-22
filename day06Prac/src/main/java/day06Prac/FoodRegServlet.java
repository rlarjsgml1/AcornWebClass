package day06Prac;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/foodReg")
public class FoodRegServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청바디 읽기
		req.setCharacterEncoding("utf-8");
		BufferedReader  br  = req.getReader();
		
		StringBuilder sb = new StringBuilder();
		
		String line;
		while( (line= br.readLine()) != null) {
			sb.append(line);
		}
		
		br.close();
		
		System.out.println( sb.toString());
		
		//{"name" : "모듬스시", "price" : 20000}
		//자바객체로 변환
		
		//서비스를 통해서 데이터베이스에 등록하기
		//1,0 성공여부
		
		JSONObject jsonBody = new JSONObject(sb.toString());
		String name = jsonBody.getString("name");
		int price = Integer.parseInt(jsonBody.getString("price"));
		
		Food food = new Food(name,price);
		
		System.out.println(food);
		
		
		resp.getWriter().print("1");
	}

}
