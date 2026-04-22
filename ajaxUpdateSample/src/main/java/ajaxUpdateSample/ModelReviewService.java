package ajaxUpdateSample;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class ModelReviewService {

	 
	ModelReviewDAO dao = new ModelReviewDAO();
	
	
	
	public ArrayList<ReviewDTO> getReviewList(){		
		return dao.selectAll();
	}
	
	

	public    JSONArray  getFoodJsonArray() {		
		ArrayList<ReviewDTO> list  = dao.selectAll();		
		JSONArray arr = new JSONArray();
		
		for( int i=0; i<list.size() ;i++) {
			ReviewDTO review = list.get(i);
			JSONObject o = new JSONObject();
			o.put("id",  review.getId());
			o.put("content",  review.getContent());				 
			arr.put(o);
		}
		
		
		return arr;	  
	}
	
	
	
	public int registerReview( ReviewDTO review) {
		return dao.insertReview(review);
		
	}
	
	
	public int modifyReview( ReviewDTO review) {
		return dao.updateReview(review);
	}
	
	
	public int cancleDelete(String id) {
		return dao.deleteReview(id);
	}
	
	
	public static void main(String[] args) {
		ModelReviewService service = new ModelReviewService();
		 System.out.println( service.getFoodJsonArray());
	}
}
