package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

public class HelloWorld {

    public static void main(String[] args)  {
        new Thread(() -> {
            try {
                sayHello();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        while (true){
            int port = 80;

            try(ServerSocket serverSocket = new ServerSocket(port)){
                System.out.println("Server is listening on port " + port);
                while (true){
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New connection accepted.");


                    new Thread(() -> handleClient(clientSocket)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    // 简单的加法函数
    public static int add(int a, int b) {
        return a + b;
    }

    public static void sayHello() throws InterruptedException {
        while (true){
            System.out.println("Hello Java " + LocalTime.now());
            Thread.sleep(3000);
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream()
        ) {
            // 处理客户端请求
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String receivedData = new String(buffer, 0, bytesRead);
                System.out.println("Received from client: " + receivedData);

                // 在这里可以添加自定义的处理逻辑

                // 回复客户端
                String responseData = "Hello, client! I received your message.";
                outputStream.write(responseData.getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
