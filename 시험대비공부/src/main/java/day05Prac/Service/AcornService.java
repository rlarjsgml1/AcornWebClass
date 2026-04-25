package day05Prac.Service;

import java.util.ArrayList;

import day05Prac.dao.AcornDAO;
import day05Prac.dto.Acorn;

public class AcornService {

//	AcornDAO dao = new AcornDAO();
//
//	public ArrayList<Acorn> getMembers() {
//		ArrayList<Acorn> result = dao.selectAll();
//		return result;
//	}
	
	
	
	AcornDAO dao = new AcornDAO();
	
	public ArrayList<Acorn> getMembers(){
		ArrayList<Acorn> result = dao.selectAll();
		return result;
	}
}
