package com.nnww.nio.chat;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Client {

    private Selector selector;

    private SocketChannel channel;

    public void senMsg(String msg) {
        try {
            channel.register(selector, SelectionKey.OP_WRITE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Client() {
        try {
            selector = Selector.open();
            channel = SocketChannel.open();
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("localhost", 8088));
            channel.register(selector, SelectionKey.OP_CONNECT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        ServerSocketChannel serverSocketChannel = null;
        try {
            while (true) {
                int selectCount = selector.select();
                if (selectCount <= 0) {
                    continue;
                }
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    channel = (SocketChannel) selectionKey.channel();
                    int i = selectionKey.interestOps();
                    if (selectionKey.isConnectable()) {
                        if (channel.isConnectionPending()) {
                            channel.finishConnect();
                            channel.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ);
                        }
                    }
                    else if (selectionKey.isWritable()) {
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        buffer.clear();
                        buffer.put("你好 server".getBytes());
                        buffer.flip();
                        channel.write(buffer);
                    }
                    else if (selectionKey.isReadable()) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int read = channel.read(byteBuffer);
                        if (read > 0) {
                            System.out.println(new String(byteBuffer.array(), 0, read));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
//        new Thread(() -> {
//            try {
//                Thread.sleep(2000);
//                client.senMsg("hello1");
//                Thread.sleep(2000);
//                client.senMsg("hello2");
//                Thread.sleep(2000);
//                client.senMsg("hello3");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }).start();
        client.run();


    }
}
