package reg;

 
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register2")
public class RegisterServlet2 extends HttpServlet {

    private MemberService service = new MemberService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender   = request.getParameter("gender");
        String role     = request.getParameter("role");
        String[] hobbies = request.getParameterValues("hobby");

        try {
            int memberId = service.register(username, password, gender, role, hobbies);

            request.setAttribute("username", username);
            request.setAttribute("gender", gender);
            request.setAttribute("role", role);
            request.setAttribute("hobbies", hobbies);
            
            
            //

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/registerSuccess.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            //throw new ServletException(e);  오류상황 뷰 제공하기
        
        }
    }
}
