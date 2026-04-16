package day02.서버;

import java.io.*;
import java.net.*;

public class SimpleThreadServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("서버 시작 (포트 8081)");

        while (true) {
            // 클라이언트 요청 대기
            Socket socket = serverSocket.accept();

            System.out.println("클라이이언트 요청  ~~접속 발생!");

            //  요청마다 스레드 생성
            new Thread(new ClientHandler(socket)).start();
        }
    }
}