package day03Prac.mvc;

public class 에이콘서비스 {
	
	AcornDAO dao =new AcornDAO();
	
	public void acornRegister(Acorn acorn) {
		dao.insertMember(acorn);
	}
}
