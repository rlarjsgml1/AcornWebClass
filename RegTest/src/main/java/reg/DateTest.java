package reg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birth=null  ;
		try {
			  birth  = sdf.parse("2001-01-01");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println(birth);
		
		
		// 
		
		
		java.sql.Date  sqlbirth  =   new  java.sql.Date(  birth.getTime());
		

		System.out.println(sqlbirth);
		
		
		
		

	}

}
