package day05Prac.Service;

import java.util.ArrayList;

import day05Prac.dao.AcornDAO;
import day05Prac.dto.Acorn;

public class AcornService {

	AcornDAO dao = new AcornDAO(); // 의존성 dependency

	public ArrayList<Acorn> getMembers() {

		ArrayList<Acorn> result = dao.selectAll();
		return result;

	}

	public boolean registerAcornStudent(Acorn acorn) {
		int rowCnt = dao.insert(acorn);
		boolean result = rowCnt == 1 ? true : false;
		return result;
	}

	public Acorn getAcornStudentById(String id) {
	    return dao.findById(id);
	}

	public boolean modifyAcornStudent(Acorn acorn) {
		int rowCnt = dao.update(acorn);
		return rowCnt == 1;
	}

	public boolean deleteAcornStudent(String id) {
		int rowCnt = dao.delete(id);
		return rowCnt == 1;
	}
}
