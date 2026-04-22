package day06Prac;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

public class FoodService {
	
	FoodDAO dao = new FoodDAO();
	
	public boolean regFood(Food food) {
		return dao.insert(food) == 1;
	}

	public JSONArray getFoodList() { // ArrayList<Food> -> JSONArray
	
		ArrayList<Food>  list = new ArrayList<>();
		list.add( new Food("볶음밥",6000));
		list.add( new Food("김밥",4000));
		list.add( new Food("쫄면",6000));
		
		// 변환시키기
		JSONArray arr = new JSONArray();
		for(Food food : list) { // food -> JSONObject 
			JSONObject o = new JSONObject();
			o.put("name", food.getName());
			o.put("price", food.getPrice());
			
			arr.put(o);
		}
		
		return arr;
		
	}
	
	public String getFoodList2() { // ArrayList<Food> -> JSONArray
		
		ArrayList<Food>  list = new ArrayList<>();
		list.add( new Food("볶음밥",6000));
		list.add( new Food("김밥",4000));
		list.add( new Food("쫄면",6000));
		
		// 변환시키기
		Gson g = new Gson();
		String result = g.toJson(list);
		return result;
		
	}
	
public String getFoodList3() { // ArrayList<Food> -> JSONArray
		
		ArrayList<Food> list = dao.selectAll();
		
		// 변환시키기
		Gson g = new Gson();
		String result = g.toJson(list);
		return result;
		
	}
	
}
