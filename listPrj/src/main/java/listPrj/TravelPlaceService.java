package listPrj;
import java.util.ArrayList;
import java.util.List;

public class TravelPlaceService {

	
	private  TravelPlaceDAO dao =new TravelPlaceDAO();
	
	
	 public  void  insertAll( List<TravelPlace>  list) {
	        dao.insertAll(list);
	         
	    }
	 
	 
		
	 public  void  updateAll( List<TravelPlace>  list) {
	        dao.updateAll(list);
	         
	    }
    public List<TravelPlace> getAllPlaces() {
        List<TravelPlace> places = new ArrayList<>();
        places.add(new TravelPlace(1, 37.5665, 126.9780, "서울시청"));
        places.add(new TravelPlace(2, 35.1796, 129.0756, "부산역"));
        places.add(new TravelPlace(3, 33.4996, 126.5312, "제주공항"));
        return places;
    }
}
