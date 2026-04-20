package day04Prac;

public class 가변인자 {
	public void printStr1(String str) {
		System.out.println(str);
	}

	public void printStr2(String str1, String str2) {
		System.out.println(str1);
		System.out.println(str2);
	}

	public void printStr가변인자(String ...a) {
		for(String str : a) {
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		//0개 짜리 배열 만들기
		int[] arr = new int [0];
		가변인자 m = new 가변인자();
		m.printStr가변인자();
		m.printStr가변인자("안녕");
		m.printStr가변인자("안녕","돌아가니");
		
	}
}
