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

//로그인 필터
 @WebFilter("*.do")
public class Filter3   implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	 
		
		
		//세션  로그인 확인
		// - 로그인되어 있으면  정상적인 흐름
		// -아니면  로그인될 수 있도록 sendRedirect()
						
		HttpServletRequest request_ = (HttpServletRequest) request;
		HttpServletResponse response_ = (HttpServletResponse) response;

		// 세션 가져오기 (없으면 null)
		HttpSession session = request_.getSession(false);
		String id = (session != null) ? (String) session.getAttribute("id") : null;

		System.out.println("hi");

		if (id != null) {   // 로그인된 경우 → 원래 흐름 요청
		    chain.doFilter(request_, response_);
		    return; // 중요! 아래 redirect 실행 방지
		}

		// 로그인되지 않은 경우 → 로그인 페이지로 redirect
		String path = request_.getContextPath();
		response_.sendRedirect(path + "/login");
	 
		
		
		
	}

}
