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

 @WebFilter("*.do")
public class Filter2 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException { 
		 
		System.out.println("filter 2");

		HttpServletRequest h_request = (HttpServletRequest) request;
		HttpServletResponse h_response = (HttpServletResponse) response;

		// 세션 가져오기 (없으면 null)
		HttpSession session = h_request.getSession(false);
		String id = (session != null) ? (String) session.getAttribute("id") : null;

		if (id != null) {
		    // 로그인 되어 있는 경우 → 요청한 서블릿으로 넘어감
		   long start = System.currentTimeMillis();
		   System.out.println("before");

		    chain.doFilter(request, response);

		     System.out.println("after");
		    long end = System.currentTimeMillis();
		    System.out.println("걸린시간" + (end-start));

		    return; // 중요! 로그인 성공 시 아래 redirect 실행 방지
		}

		// 로그인 되어 있지 않으면 로그인 페이지로 redirect
		String path = h_request.getContextPath(); // 프로젝트 이름
		h_response.sendRedirect(path + "/login");
		
		
	}

}
