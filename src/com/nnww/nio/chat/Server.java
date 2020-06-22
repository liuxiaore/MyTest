package com.nnww.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {

    private Selector selector;

    private ServerSocketChannel channel;

    public Server() {
        try {
            selector = Selector.open();
            channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.bind(new InetSocketAddress("localhost", 8088));
            channel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        SocketChannel clientChanel = null;
        while (true) {
            try {
                int count = selector.select();
                if (count <= 0) {
                    continue;
                }
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isAcceptable()) {
                        clientChanel = channel.accept();
                        clientChanel.configureBlocking(false);
                        clientChanel.register(selector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                        clientChanel = (SocketChannel) selectionKey.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int read = clientChanel.read(buffer);
                        String str = new String(buffer.array(), 0, read);
                        if (read > 0) {
                            System.out.println("来自客户端消息: " + str);
                        }
                        buffer.clear();
                        buffer.put(("收到了 " + str).getBytes());
                        buffer.flip();
                        clientChanel.write(buffer);
                    }
//                    else if (selectionKey.isWritable()) {
//                        clientChanel = (SocketChannel) selectionKey.channel();
//                        ByteBuffer buffer = ByteBuffer.allocate(1024);
//                        buffer.put("收到了".getBytes());
//                        buffer.flip();
//                        clientChanel.write(buffer);
//                    }
                    iterator.remove();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }
}
