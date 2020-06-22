package com.nnww.thread.netty权威指南.NIO;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class TimeServer {

    public static void main(String[] args) throws IOException {
//        //代开ServerSocketChannel,他是所有客户端连接的父管道
//        ServerSocketChannel acceptorVsr = ServerSocketChannel.open();
//        //绑定监听端口,设置为非阻塞模式
//        InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getByName("IP"), 7080);
//        acceptorVsr.bind(inetSocketAddress);
//        acceptorVsr.configureBlocking(false);
//        //创建Reacktor,创建多路复用器(Selector)
//        Selector selector = Selector.open();
//        new Thread(new ReacktorTask()).start();
//        //将ServerSocketChannel注册到Reactor线程的多路复用器上
//        acceptorVsr.register(selector, SelectionKey.OP_ACCEPT, ioHandler);
//        selector.select();

    }
}
