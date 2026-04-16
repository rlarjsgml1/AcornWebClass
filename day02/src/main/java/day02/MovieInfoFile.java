package day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mymovie")
public class MovieInfoFile extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String path = getServletContext().getRealPath("/movies.txt");
		System.out.println(path);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            
            String line;
            
            out.println("<html>");
    		out.println("<head>");
    		out.println("<style>");
    		out.println("table{  border:1px solid black; }");
    		out.println("td{  border:1px solid black; }");
    		out.println("</style>");
    		out.println("</head>");
    		out.println("<body>");
    		out.println("<table>");
    		out.println("<tr>");
    		out.println("<td>영화제목</td>");
    		out.println("<td>상영시간</td>");
    		out.println("<td>배우</td>");		 
    		out.println("</tr>");
    		
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                
                String title = data[0];
                String genre = data[1];
                String runningTime = data[2];

                MyMovie m = new MyMovie(title, genre, runningTime);
                
                
                out.println("<tr>");
        		out.println("<td>" + m.getTitle() +"</td>");
        		out.println("<td>" + m.getGenre()+"</td>");
        		out.println("<td>" +m.getRunningTime() +"</td>");		 
        		out.println("</tr");	
            }
            
            out.println("</table>");
    		out.println("</body>");
    		out.println("</html>");
    		out.println("</body>");
    		out.println("</html>");
         
            reader.close();
        } catch (IOException e) {
            out.println("파일을 읽는 도중 오류가 발생했습니다: " + e.getMessage());
        }
		
		
	}
}
