package day04Prac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class 날짜데이터다루기2 {
	public static void main(String[] args) throws ParseException {
		
		String id = "hee";
		String pw = "1234";
		String name = "김건희";
		int point = 9999;
		Date birth = null;
		
		//"문자열" -> Date 변환하기
		//"2002-10-10"
		String strBirth = "2002-10-10";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
		
		try {
			birth = sf.parse(strBirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(birth);
		
		//Date 현재날짜 가져오기
		Date now = new Date();
		System.out.println(now);
		
		//년월일 얻기
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1); //월은 0부터
		
		
		//최신
		LocalDate today = LocalDate.now();
		System.out.println(today.getYear());
		System.out.println(today.getMonth());
		System.out.println(today.getMonthValue());
	}
}
