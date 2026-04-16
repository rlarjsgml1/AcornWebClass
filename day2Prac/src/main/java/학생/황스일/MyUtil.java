package 학생.황스일;

import java.util.ArrayList;

//자바로 라이브러리(기능). 함수 만들기
//클래스 기능(메서드)
public class MyUtil {
	
	//기능 : 약수구하기
	//입력(매개변수)
	//반환 : ArrayList<Integer>
	
	public ArrayList<Integer> getDivisor( int num){
		
		ArrayList<Integer> result = new ArrayList<>();
		for( int i =1 ; i<=num; i++){
			if(num%i ==0) {
				result.add(i);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		MyUtil util = new MyUtil();
		ArrayList<Integer> list =  util.getDivisor(12);
		System.out.println(list);
	}
}
