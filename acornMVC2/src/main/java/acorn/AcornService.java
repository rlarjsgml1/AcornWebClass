package acorn;

import java.util.ArrayList;

public class AcornService {

	
	AcornDAO dao = new AcornDAO();
	
	//학생정보가져오기 ( 매개변수 ,  반환 )	
	public ArrayList<Acorn> getMemberListTmp(){		
		ArrayList<Acorn>  list =  new  ArrayList<>();		
		list.add( new Acorn("dh","1234","홍길동"));
		list.add( new Acorn("mg","5678","이순신"));
		list.add( new Acorn("sj","4682","심청이"));				
		return list;		
		
	}
	
	public ArrayList<Acorn> getAcornStudentList(){		
		ArrayList<Acorn> list  =dao.findAll();
		return list;		
	}
	

	
	public Acorn getAcornStudentById(String id ) {		
		Acorn acorn  = dao.findById(id);
		return acorn;
	}
	
	
	
	public boolean registerAcornStudent(Acorn acorn) {			
		int cnt =dao.insert(acorn);
		boolean result     = (cnt>0)? true:false;
		return result;
	}
	
	
	
	public boolean deleteAcornStudent( String id) {		 
		int cnt =dao.delete(id);
		boolean result     = (cnt>0)? true:false;
		return result;
		
	}
	
	public  boolean modifyAcornStudent( String id, String newpw) {
		int cnt =dao.update(id, newpw);
		boolean result     = (cnt>0)? true:false;
		return result;
	}
	
	
	
	public static void main(String[] args) {
		AcornService service = new AcornService();
		ArrayList<Acorn>  list=service.getAcornStudentList();
		
		for( int i=0; i< list.size() ; i++) {
			 System.out.println( list.get(i));
		} 		
	}
	
	
}
