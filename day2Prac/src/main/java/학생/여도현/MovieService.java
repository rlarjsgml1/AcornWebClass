package 학생.여도현;

public class MovieService {

	//영화정보 제공하기
	//입력 : x 
	//반환 : Movie
	
	public Movie getMovie() {
		Movie m = new Movie("영화제목","영화감독",2026);
		return m;
	}
	
}
