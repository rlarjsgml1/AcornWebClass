package day04Prac;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Acorn {
	
	String  id;
	String  pw;
	String  name;
	int point;
	Date birth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getBirth() {
		return birth;
	}
	
	
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Acorn(String id, String pw, String name, int point, Date birth) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.point = point;
		this.birth = birth;
	}
	
	//생성자 , 기본생성자 
	//setter, getter
	//toString
	public Acorn() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		
		String birthStr="";
		SimpleDateFormat sf  = new SimpleDateFormat("yyyy/MM/dd");
		if( birth != null) {
			birthStr  =   sf.format(birth);   // date  -> 문자열로 변환
		
		}
		//System.out.println(birthStr);
		
		
		return "Acorn [id=" + id + ", pw=" + pw + ", name=" + name + ", point=" + point + ", birth=" + birthStr + "]";
	}
	

}
