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


// ServletRequest , ServletResponse   // HttpServletRequest, HttpServletResponse 의 부모형이다
// 업캐스팅된 상태로 받는다.


//@WebFilter("*.acorn")
public class LoginFilter    implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		// 다운캐스팅
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// 세션 가져오기 (false → 세션 없으면 null)
		HttpSession session = req.getSession(false);
		 
		
		if (session != null) {
		    String  id=(String) session.getAttribute("id");	  
			if (id != null) {   // 로그인 되어 있는 경우
			    // 서블릿이 실행되기 전에 수행할 코드
				
			    chain.doFilter(request, response);
			    // 서블릿이 실행된 후 응답되기 전에 수행할 코드
			    
			    return; // 중요! 여기서 종료 → 아래 redirect 실행 방지
			} 
		} 
		

		// 로그인 되어 있지 않으면 로그인 페이지로 redirect
		String path = req.getContextPath();
		resp.sendRedirect(path + "/login");
		
		
		
	}

}
