package dao;

import java.util.ArrayList;

public class AcornService {
	
	AcornDAO dao = new AcornDAO();	
	
	
	//임시 학생정보 제공
	public ArrayList<String>  getMemberList(){			
		ArrayList<String> list  = new ArrayList<>();
		
		list.add("홍길동");
		list.add("이순신");
		list.add("심청이");		
		return list; 
	}	
	
	
	 	
	//dao를 통해서 실제 학생정보를 가져옴
	public ArrayList<Customer> getMemberRealList (){	
		 ArrayList<Customer> list  =dao.selectAll();
		 return list;
		
	}
	
	//등록하기
	public void  registerMember( Customer c ) {		
		dao.insertMember3(c);
	}
	
	
	//한 학생 조회하기	
	public Customer getMember(String id) {
		Customer c =dao.selectOne(id);
		return c;
	}
	
	
	//한 학생 삭제
	public  void deleteMember(String id) {
		dao.deleteOne(id);
	}
	  
	
	//학생정보 변경
	public void modifyMember( String id, String pw) {
		dao.updateMember(id , pw);
	}
	

}
