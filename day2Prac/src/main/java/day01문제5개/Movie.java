package day01문제5개;

public class Movie {
    private String title;
    private String director;
    private String genre;
    private int runningTime;

    public Movie(String title, String director, String genre, int runningTime) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.runningTime = runningTime;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public int getRunningTime() {
        return runningTime;
    }
}