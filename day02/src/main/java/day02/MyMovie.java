package day02;


public class MyMovie {
	
	private String title;
	private String genre;
	private String runningTime;
	
	
	
	public MyMovie(String title, String genre, String runningTime) {
		super();
		this.title = title;
		this.genre = genre;
		this.runningTime = runningTime;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	@Override
	public String toString() {
		return "MyMovie [title=" + title + ", genre=" + genre + ", runningTime=" + runningTime + "]";
	}
	
	
	
	
	
}
