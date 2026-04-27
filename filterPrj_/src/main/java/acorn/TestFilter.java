package acorn;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter("/test")
public class TestFilter  implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 
		
		
		//필터에서 확인 하기 
		
		
		 HttpServletRequest  req   =  (HttpServletRequest) request;
		 HttpServletResponse resp  = ( HttpServletResponse) response;
		 
		 
		 
		 //로그인 정보확인하기 
		 
		 
		 HttpSession session  = req.getSession(false);
		 
		 
		 if( session != null) {
			 String id  =( String)  session.getAttribute("id");			 
		
			 // 
			 if( id !=null) {
				 chain.doFilter(req, resp);
				 return;
				 
			 }
		 }
		 
			 
		resp.sendRedirect(req.getContextPath()+"/login");
			  
		
	}

}
 