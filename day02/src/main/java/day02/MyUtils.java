package day02;

public class MyUtils {
	
	
	
	// 10까지의 합
	public int getTen() {
		
		int sum=0;
		for( int i=1 ; i<=10; i++) {
			sum+= i;
		}
		
		return sum;
	}
	
	
	//약수구하기 
	public String  getDivisor(int su) {
		
		int[ ]   arr = new int[20];  //20 
		int index=0;
		//4   ->  1,2,3,4    =>1 ,2 ,4
		for( int i=1 ; i<=su ; i++) {
			if( su % i ==0) {
				arr[index]= i;
				index++;
			}
		}
		
		//
		String result="";
		for( int  i=0 ; i< index ;i++) {
			result += arr[i]  +" ";
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		MyUtils m = new MyUtils();
		String result  =m.getDivisor(12);
		System.out.println( result);
		
	}

}
