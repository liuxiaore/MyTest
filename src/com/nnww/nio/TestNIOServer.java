package com.nnww.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;


/**
 * 视频地址https://v.qq.com/x/page/s0519en4ncm.html
 */

public class TestNIOServer {

//    通道
    ServerSocketChannel serverChannel;
//    监视器
    Selector selector;

    public void start() {
        try {
            serverChannel = ServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress("localhost", 8888));
            serverChannel.configureBlocking(false);
            selector =  Selector.open();

//          将服务端通道注册到监视器
//          设置当客户端请求的时候触发通道的某一个方法(操作)
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bindEvent() {
        while(true) {
            try {
//              扫描整个监视器,意思是如果服务端没有请求,导致没有操作就绪,就会返回0
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
                    if (selectionKey.isAcceptable()) {
//                        返回一个客户端通道
                        SocketChannel client = serverChannel.accept();
                        client.configureBlocking(false);
//                        注册客户端通道
                        client.register(selector, SelectionKey.OP_READ);

                    } else if (selectionKey.isReadable()) {
//                        返回一个客户端通道
                        SocketChannel client = (SocketChannel) selectionKey.channel();
//                        缓存/分配大小
                        ByteBuffer buff = ByteBuffer.allocate(1024);
//                        数据从通道读到缓存
                        int len = client.read(buff);
                        if (len > 0) {
                            System.out.println("服务端拿到了客户端的数据,内容是:" + new String(buff.array(), 0, len));
                            client.register(selector, SelectionKey.OP_WRITE);
                        }
                    }
                    iterator.remove();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestNIOServer testNIOClient = new TestNIOServer();
        testNIOClient.start();
        testNIOClient.bindEvent();

    }
}
