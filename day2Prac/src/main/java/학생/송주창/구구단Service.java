package 학생.송주창;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 구구단Service {
	//기능 : 3단을 제공하기
	//입력 : x
	//반환 : String[]
	public String[] get구구단3() {
		String[] dan3 = new String[9]; // 3*1 = 3
//		dan3[0] = "3 * 1 = " + 3*1;
//		dan3[1] = "3 * 2 = " + 3*2;
//		dan3[2] = "3 * 3 = " + 3*3;
//		dan3[3] = "3 * 4 = " + 3*4;
//		dan3[4] = "3 * 5 = " + 3*5;
//		dan3[5] = "3 * 6 = " + 3*6;
//		dan3[6] = "3 * 7 = " + 3*7;
//		dan3[7] = "3 * 8 = " + 3*8;
//		dan3[8] = "3 * 9 = " + 3*9;
		for(int i = 0; i< 9; i++) {
			dan3[i] = "3*" + (i+1) + "=" + 3*(i+1); 
		}
		
		System.out.println(dan3[0]);
		return dan3;
	}
	
	public static void main(String[] args) {
		구구단Service service = new 구구단Service();
		String[] reuslt = service.get구구단3();
		System.out.println(Arrays.toString(reuslt));
	}
}
