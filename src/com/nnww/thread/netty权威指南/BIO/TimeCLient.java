package com.nnww.thread.netty权威指南.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TimeCLient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 7080);
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();
            if (text.equals("exit")) {
                break;
            }
            out.println(text);
            System.out.println("发送内容为:" + text);
            System.out.println("接受的内容: " + reader.readLine());
        }
    }
}
