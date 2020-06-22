package com.nnww.io;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;


public class IOTest {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\liu\\Desktop\\profile");
        FileReader reader = new FileReader(file);
        char[] chars = new char[1024];
//        int read = reader.read(chars);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String read = bufferedReader.readLine();
        File file2 = new File("C:\\Users\\liu\\Desktop\\io.txt");
        FileWriter fileWriter = new FileWriter(file2);
        fileWriter.write(read);
        reader.close();
        bufferedReader.close();
        fileWriter.close();
        System.out.println(read);
    }

    @Test
    public void test1() {
        String packge = "椿上民宿";
        String path = "C:\\Users\\liu\\Desktop\\推荐\\" + packge;
        File file = new File(path);
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                File node = files[i];
                node.renameTo(new File("C:\\Users\\liu\\Desktop\\推荐\\" + packge + "\\" + i + ".jpg"));
            }
        }
    }

    @Test
    public void test2() throws IOException {
        File file = new File("C:\\Users\\zhangjinhao\\Desktop\\新建文本文档.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        byte[] bytes = new byte[1024];
        int i = 0;
        while ((i = bufferedReader.read()) > 0) {
            String s = bufferedReader.readLine();
            System.out.println(s);

        }

    }

    @Test
    public void test3() throws IOException {

        File file = new File("C:\\Users\\zhangjinhao\\Desktop\\新建文本文档.txt");
        FileInputStream inputStream = new FileInputStream(file);
        FileChannel channel = inputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        int read = 0;
        if ((read = channel.read(buffer)) != -1){

        }

    }
}
