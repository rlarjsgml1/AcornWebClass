package mapPrj;

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


@WebServlet("/map1")
public class MapMVCServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		//Map을 사용하는 경우 , 별도의 클래스를 만들 필요없다
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
		 
		 req.getRequestDispatcher("WEB-INF/views/jsonMap.jsp").forward(req, resp);
		
	}

}
