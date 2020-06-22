package com.nnww.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TestNIOClient {

    Selector selector;
    SocketChannel clientChannel;

    public void start() {
        try {
            clientChannel = SocketChannel.open();
            clientChannel.configureBlocking(false);
            clientChannel.connect(new InetSocketAddress("localhost", 8888));
            selector = Selector.open();
            clientChannel.register(selector, SelectionKey.OP_CONNECT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void bindEvent() {
        while(true) {
            try {
                //select()方法返回的int值表示有多少通道已经就绪,是自上次调用select()方法后有多少通道变成就绪状态
                int i = selector.select();
                if (i == 0) {
                    continue;
                }
//                拿到这些通道集合
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
//                    如果这个通道是可接收的
                    if (selectionKey.isConnectable()) {
                        if (clientChannel.isConnectionPending()) {
                            clientChannel.finishConnect();
                            clientChannel.register(selector, SelectionKey.OP_WRITE);
                        }

                    } else if (selectionKey.isWritable()) {
//                        缓存/分配大小,将数据写到缓冲
                        ByteBuffer buff = ByteBuffer.allocate(1024);
//                        清空一下
                        buff.clear();
                        buff.put("你好啊,服务器".getBytes());
                        buff.flip();
                        clientChannel.write(buff);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        TestNIOClient testNIOClient = new TestNIOClient();
        testNIOClient.start();
        testNIOClient.bindEvent();
    }
}
