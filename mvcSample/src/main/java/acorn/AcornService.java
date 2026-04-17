package acorn;

import java.util.ArrayList;

public class AcornService {
	
	AcornDAO dao = new AcornDAO();
	
	
	//에이콘학생명단
	public ArrayList<String>  getMemberList(){			
		ArrayList<String> list  = new ArrayList<>();
		
		list.add("이상민");
		list.add("소병학");
		list.add("최형진");	
		list.add("백바울");
		list.add("송병화");
		
		return list; 
	}	
	
	 
	
	public ArrayList<Customer> getMemberRealList (){	
		 ArrayList<Customer> list  =dao.selectAll();
		 return list;
		
	}
	 
	

}
