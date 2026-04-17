package day03Prac.mvc;

public class 구구단서비스 {
	
	public String[] getDan3() {
		
		String[] dan3 = new String[9];
		/*
		dan3[0] = "3*" +  1 +"=" + 3*1;
		dan3[1] = "3*" +  2 +"=" + 3*2;
		dan3[2] = "3*" +  3 +"=" + 3*3;
		dan3[3] = "3*" +  4 +"=" + 3*4;
		dan3[4] = "3*" +  5 +"=" + 3*5;
		dan3[5] = "3*" +  6 +"=" + 3*6;
		dan3[6] = "3*" +  7 +"=" + 3*7;
		dan3[7] = "3*" +  8 +"=" + 3*8;
		dan3[8] = "3*" +  9 +"=" + 3*9;
		*/
		
		for(int i = 1; i<=9; i++){
			dan3[i-1] = "3*" + i + "=" + (3*i);
		}
		return dan3;
	}
	
	public static void main(String[] args) {
		구구단서비스 service = new 구구단서비스();
		String[] result = service.getDan3();
		
		for(int i =0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
