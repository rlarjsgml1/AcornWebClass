package day09Prac;

public class HelloService {
	
	public int getLength(String str) throws Exception {
		int cnt = 0;
		try {
			cnt = str.length(); // 예외발생할 수 있는 코드

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return cnt;
	}
}
