package mvc;

public class ServiceMVC6 {
	
	public String dan3Ver1() {
		
		StringBuilder sb  = new StringBuilder();
		for( int i=1; i<9; i++) {
			sb.append( "3*" +i + "=" + 3*i + "<br>");
		}		
		
		return sb.toString();
	}

	
	
	public String[] dan3Ver2() {		
		String[] dan = new String[9];
		for( int i=1; i<=9; i++) {
			dan[i-1]= "3*" +i + "=" + 3*i + "<br>" ;
		}		
		
		return dan;
	}
	
	public static void main(String[] args) {
		ServiceMVC6  s = new ServiceMVC6();
		String   result  =s.dan3Ver1();
		System.out.println( result);
		
		
	}
}
