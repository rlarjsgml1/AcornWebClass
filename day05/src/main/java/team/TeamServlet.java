package team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/team")
public class TeamServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 
		//이름목록 준비하기 : 배열이 아닌 ArrayList로 준비함, 삭제를 편리하게 하기 위함
		//조원으로 선택된 이름은 제거되어야 함  ( 똑같은 사람은 다른 조에 또 편성되면 안됨)
         ArrayList<String > names= new ArrayList<>();
         /*
           
          * 
          */
         names.add("김건희");
         names.add("김태준");
         names.add("고지연");
         names.add("황스일");
         names.add("김민정");
         names.add("이현겸");
         names.add("이용찬");
         names.add("여도현");
         names.add("장해든");
         names.add("박세인");
         names.add("조아진");
         names.add("김재민");
         names.add("정철진");
         names.add("이정하");
         names.add("엄진희");
         names.add("장윤성");
         names.add("김민경");
         names.add("손영석");
         names.add("송주창");
         names.add("나해수");
         
       
     
		
		  /*
		   * 0. Hashmap생성하기 (5개조를 담을  Map생성:  각 조 정보  set을 여러개 담기 위함  )
		   * 1.반복
		   *   1.1 조원이름을 담을 각 Hashset 생성 (중복되는 이름이 담기지 않도록 set사용)
		   *   1.2 반복(5명의 조원이 담길 때 까지)
		   *      - 난수발생
		   *      - 이름목록에서 난수번째 이름을 set에 담는다
		   *      - 이름목록에서 이름 삭제함		    
		   *   1.3 각 조원명단을 map에 저장
		   * 
		   * 
		   */
         
		
		 Random r = new Random();	
		 
		 //팀정보
		 HashMap<Integer , HashSet<String>> teams  = new HashMap<>(); // key -value 값을 저장할 수 있음 (검색에 용이함)
		
		 //4개조 
		 for( int i=1; i<=4 ;i++) { 
			 // 각 조원이름을 담을 HashSet 생성
			 HashSet<String>  teamNames = new HashSet<>();	
			 while(teamNames.size() <5) {   //5명이 담길때 까지 반복한다
			 	int index  =r.nextInt( names.size());		
			 	teamNames.add(names.get(index));
			 	names.remove(index);
			 }
			 
			 teams.put(i, teamNames);
		 }
		 
		 
		 
		 System.out.println( teams);
		 
		 //만들어진 Map정보 ( 각 조원들의 명단 정보를 저장소에 저장)		  
		 request.setAttribute("result", teams);
		 
		 //view로 포워드
		 request.getRequestDispatcher("/WEB-INF/views/teamResult.jsp").forward(request, response); 
		
		
	}
	
}
