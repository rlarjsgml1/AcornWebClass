package transactionSample;
 

 

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

@WebServlet("/order/insert")
public class OrderInsertServlet extends HttpServlet {

    private OrderService orderService = new OrderService();
    
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            // 1. 주문 기본 정보 수집
            String customerId = request.getParameter("customerId");

            // 2. 주문상세 정보 수집 (여러 상품 가능)
            String[] productIds = request.getParameterValues("productId");
            String[] quantities = request.getParameterValues("quantity");
            String[] prices = request.getParameterValues("price");

            // 3. Order 객체 생성
            Order order = new Order();
            order.setCustomerId(customerId);

            // 4. OrderDetail 리스트 생성
            List<OrderDetail> detailList = new ArrayList<>();
            if (productIds != null) {
                for (int i = 0; i < productIds.length; i++) {
                    OrderDetail detail = new OrderDetail();
                    detail.setProductId(productIds[i]);
                    detail.setQuantity(Integer.parseInt(quantities[i]));
                    detail.setPrice(Integer.parseInt(prices[i]));
                    detailList.add(detail);
                }
            }

            // 5. 주문 등록 서비스 호출 (트랜잭션 포함)
            orderService.placeOrder(order, detailList);

            // 6. 결과 페이지로 이동
            System.out.println("dkdkdk");
            request.getRequestDispatcher("/WEB-INF/views/order/success.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            // 실패 시 에러 페이지로 이동
            request.getRequestDispatcher("/WEB-INF/views/order/error.jsp").forward(request, response);
        }
    }
}
