package listPrj;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet("/updateAll")
public class TravelUpdateAllServlet extends HttpServlet {
   // private TravelPlaceDAO dao = new TravelPlaceDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
       
        
        //요청바디 읽기
        String jsonData = req.getReader().lines().collect(Collectors.joining());        
        System.out.println(jsonData );
        
                
        // JSON 리스트  -> Java List 변환
        Gson gson = new Gson();
        Type listType = new TypeToken<List<TravelPlace>>(){}.getType();
        List<TravelPlace> placeList = gson.fromJson(jsonData, listType);
        
        
        //
        System.out.println("자바객체로 변환하는 목록 확인하기!");
        System.out.println(  placeList);
        
        
        
        TravelPlaceService service = new TravelPlaceService();
        service.updateAll( placeList);
        
        /*

        //변경하기 
        for(TravelPlace p : placeList) {
           // dao.update(p);
        }
         */
        resp.setContentType("application/json");
        resp.getWriter().write("{\"status\":\"ok\"}");
    }
}
