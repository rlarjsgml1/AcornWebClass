package day02.서버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

 public class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println("처리 스레드: " + threadName);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            // 요청 읽기 (HTTP 요청 첫 줄)
            String requestLine = in.readLine();
            System.out.println("요청: " + requestLine);

            // 일부러 지연 → 동시성 확인
            Thread.sleep(3000);

            // HTTP 응답
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html;charset=utf-8");
            out.println();
            out.println("Hello from thread: 서버가 보낸응답 데이터: 주문정보 " + threadName);

			Random random = new Random();
			
			String[] foods = {"치킨", "피자", "햄버거", "콜라", "파스타"};
			
			out.println("<ul>");
			
			for (int i = 0; i < 3; i++) {
			    int orderId = 1000 + random.nextInt(900); // 1000~1899
			    String food = foods[random.nextInt(foods.length)];
			    int qty = 1 + random.nextInt(5);
			
			    out.println("<li>주문번호: " + orderId +
			                " / 상품: " + food +
			                " / 수량: " + qty + "</li>");
           }

			out.println("</ul>");

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}