package listPrj;
 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/travel/list")
public class TravelListServlet extends HttpServlet {

    private TravelPlaceService service = new TravelPlaceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TravelPlace> places = service.getAllPlaces();
        req.setAttribute("places", places);
        req.getRequestDispatcher("/WEB-INF/views/travelList.jsp").forward(req, resp);
    }
}
