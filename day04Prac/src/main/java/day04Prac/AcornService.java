package day04Prac;

import java.util.ArrayList;

public class AcornService {

	//
	
	AcornDAO2 dao = new AcornDAO2();
	
	public ArrayList<Acorn> getMembers(){		
		return  dao.selectAll();
	}
	
	public int registerMember(Acorn acorn) {
		return dao.insertMember(acorn);
	}

}
