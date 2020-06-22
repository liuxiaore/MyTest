package com.nnww.test.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestBioServer {

    ServerSocket server;

    public TestBioServer(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("io服务器已经启动,监控的端口是:" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            try {
                Socket client = server.accept();
                InputStream inputStream = client.getInputStream();
                byte[] buff = new byte[1024];
                int len = inputStream.read(buff);
                if (len > 0) {
                    String message = new String(buff, 0, len);
                    System.out.println("服务器已经接受到客户端内容" +
                            ",内容是: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new TestBioServer(9999).start();
    }
}
