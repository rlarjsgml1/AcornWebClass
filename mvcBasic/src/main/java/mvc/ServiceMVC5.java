package mvc;

import java.util.ArrayList;

public class ServiceMVC5 { 
	
	 public ArrayList<Member> getList(){		 
		 
		 ArrayList<Member> list = new ArrayList<>();
		 list.add( new Member("dh" , "4482" , "김도현"));
		 list.add( new Member("mg" , "1234" , "김무궁"));
		 list.add( new Member("sj" , "0000" , "김세중"));		 		 
		 return list;	 
		 
	 }
}
