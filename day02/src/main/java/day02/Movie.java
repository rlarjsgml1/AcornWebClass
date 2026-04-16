package day02;

public class Movie {

	String name;
	String runningtime;
	String actor;
	
	
	public Movie(String name, String runningtime, String actor) {
		super();
		this.name = name;
		this.runningtime = runningtime;
		this.actor = actor;
	}


	@Override
	public String toString() {
		return "Movie [name=" + name + ", runningtime=" + runningtime + ", actor=" + actor + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRunningtime() {
		return runningtime;
	}


	public void setRunningtime(String runningtime) {
		this.runningtime = runningtime;
	}


	public String getActor() {
		return actor;
	}


	public void setActor(String actor) {
		this.actor = actor;
	}
	
	
	
	
	
}
