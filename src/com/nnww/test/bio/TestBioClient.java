package com.nnww.test.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TestBioClient {

    public static void main(String[] args) {

        try {
            Socket client = new Socket("localhost", 9999);
            OutputStream out = client.getOutputStream();
            out.write("你好".getBytes());
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
