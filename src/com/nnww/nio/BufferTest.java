package com.nnww.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

public class BufferTest {

    @Test
    public void test() {
        String abcd = new String("abcd");
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("--------put");
        buffer.put(abcd.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("--------get");
        System.out.println(buffer.position());
        buffer.flip();
        byte[] getByte = new byte[2];
        buffer.get(getByte, 0, getByte.length);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());



    }
}
