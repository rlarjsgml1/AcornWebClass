package day04Prac;

public class Ex03Service {
	
	//학생정보가져오기
	
	//기능 : 학생정보 제공
	//입력 :x
	//반환 : Score
	
	public Score getScore(){
		
		Score score = new Score("홍길동",100,90,100);
		return score;
	}
	
	public static void main(String[] args) {
		Ex03Service e = new Ex03Service();
		Score s = e.getScore();
		System.out.println(s.getEng());
		System.out.println(s.getKor());
		System.out.println(s.getMath());
	}

}
