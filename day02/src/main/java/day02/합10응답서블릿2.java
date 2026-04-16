package day02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hap10ver2")
public class 합10응답서블릿2  extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// /hap10ver2?su=5
		
		String su_ = request.getParameter("su");
		int su;
		if( su_  == null) {
			su=10;
		}else {
			su  = Integer.parseInt(su_);    // "1 2 5"  =>  125
		}
		
		
		
		int sum=0;
		for( int i=1 ; i<=su; i++) {
			sum += i;
		}
		
		
		PrintWriter  out  = response.getWriter();
		out.println(sum );
		
		
		
	}
}
