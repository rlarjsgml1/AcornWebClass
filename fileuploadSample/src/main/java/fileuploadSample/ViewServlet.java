package fileuploadSample;
 

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = request.getParameter("fileName");
        request.setAttribute("fileName", fileName);

       
        request.getRequestDispatcher("/WEB-INF/views/view.jsp").forward(request, response);
    }
}
