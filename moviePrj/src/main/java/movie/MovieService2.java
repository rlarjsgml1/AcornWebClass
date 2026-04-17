package movie;

import java.util.ArrayList;

public class MovieService2 {
	
	
	MovieDAO dao = new MovieDAO();
	
	
	public ArrayList<Movie>  getMoveListAll(){				
		
	 return dao.selectAll();
		
		
	}

}
