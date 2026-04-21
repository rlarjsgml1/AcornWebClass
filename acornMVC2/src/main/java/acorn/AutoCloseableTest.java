package acorn;




// Connection, PrepareStatement, ResultSet 모두  AutoCloseable을 구현하였다

class  A  implements  AutoCloseable{

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("  A  close합니다");
		
	}
	
}



class  B  implements  AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("  B  close합니다");
		
		
	}
	
}

public class AutoCloseableTest {

	public static void main(String[] args) {
		
		
		AutoCloseable[] list  = new AutoCloseable[2];
		
		
		list[0]=new A();
		list[1]=new B();
		
		
		
		for( AutoCloseable auto : list) {
			try {
				auto.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
