package 학생.여도현;

public class Movie {
	private String title;
	private String director;
	private int year;
	
	public Movie(String title, String director, int year) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.director = director;
		this.year = year;
	}
	
	public String getTitle() {
		return title;
	}
	public String getDirector() {
		return director;
	}
	public int getYear() {
		return year;
	}
}
