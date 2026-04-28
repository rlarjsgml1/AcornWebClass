package maptest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


//식당정보를 지도에 보여주기 (지도라이브러)
@WebServlet("/maptest2")
public class Map2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		//서비스 dao를 이용해서 맛집정보 리스트 가져오기 ,  json  변환 
		
		// 자바객체 리스트 => json array (자바스크립트 객체)
		
		
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("title", "heldlo");
		jsonMap.put("la", "35.190165");
		jsonMap.put("lg", " 126.808852");
		 
		Map<String, String> jsonMap2 = new HashMap<String, String>();
		jsonMap2.put("title", "hello2");
		jsonMap2.put("la", "35.139558");
		jsonMap2.put("lg", "126.793159");
		
		ArrayList< Map<String, String>>  item = new ArrayList< Map<String, String>> ();
		item.add(jsonMap);
		item.add(jsonMap2);
		

		
		/*자바객체를 json으로 변환해 줌 */ 
		 Gson gson = new GsonBuilder().create();	 
		 String json2  = gson.toJson(item);   
		
		
		 System.out.println( json2); 
		 req.setAttribute("item2", json2);
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/map2test.jsp").forward(req, resp);
		
	}
}
