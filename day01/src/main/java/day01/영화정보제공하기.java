package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/movieBest")

public class 영화정보제공하기  extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out  = resp.getWriter();		
		
	 
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write(".wrap{\n");
		out.write(" width :1280px;\n");
		out.write(" margin: 0 auto;\n");
		out.write("}\n");
		out.write("</style>\n");
		out.write("</head>\n");
		out.write("<body>\n");

		out.write("<div class=\"wrap\">\n");
		out.write("<p class=\"se-text-paragraph se-text-paragraph-align- \" style=\"line-height:1.9;\"> 2026년 2월 극장가를 점령한 <span style=\"background-color:#fff8b2;\">**영화 '왕과 사는 남자(왕사남)'**</span>가 개봉 20일 만에 누적 관객수 600만 명을 돌파하며 천만 영화를 향해 질주하고 있습니다.</p>\n");

		out.write("<img src=\"https://postfiles.pstatic.net/MjAyNjAyMjNfMzQg/MDAxNzcxODUyNjg2OTIx.C8BjtcoTi_Fg0qMx3VoSz6eGQ7rkyWBpapZuJdKg5Eog.9ojzBif0n2CUADbHOoKvNYburmnA4jYbeDbboPRMCZYg.PNG/image.png?type=w966\">\n");

		out.write("<table border=\"1\" style=\"width:100%; border-collapse:collapse;\">\n");
		out.write("<tr><th>항목</th><th>상세 내용</th></tr>\n");
		out.write("<tr><td>개봉일</td><td>2026년 2월 4일</td></tr>\n");
		out.write("<tr><td>감독/배급</td><td>장항준 / 쇼박스</td></tr>\n");
		out.write("<tr><td>주연 배우</td><td>유해진, 박지훈, 유지태, 전미도 등</td></tr>\n");
		out.write("<tr><td>상영 시간</td><td>117분 (1시간 57분)</td></tr>\n");
		out.write("<tr><td>관람 등급</td><td>12세 이상 관람가</td></tr>\n");
		out.write("<tr><td>쿠키 영상</td><td>없음</td></tr>\n");
		out.write("</table>\n");

		out.write("</div>\n");
		out.write("</body>\n");
		out.write("</html>\n");
		out.close();
		 
		
		
		
	}

}
