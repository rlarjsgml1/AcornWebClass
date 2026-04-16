package day02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/divisor")
public class Divisor extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String _su = req.getParameter("su");
		
		PrintWriter out = resp.getWriter();
		
		if(_su == null) {
			out.println("null");
		} else {
			int su = Integer.parseInt(_su);
			String result = getDevisor(su);
			
			out.println(result);
		}
	}
	
	
	public String getDevisor(int n) {
		
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 1; i <= n; i ++) {
			if(n % i == 0) {
				al.add(i);
			}
		}
		return al.toString();
	}
}


