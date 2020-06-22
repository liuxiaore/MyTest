package com.nnww.netty.test1.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EChoServer {

    private final int port;

    public EChoServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new EChoServerHandler());
                    }
                });
        ChannelFuture f = bootstrap.bind().sync();
        System.out.println(EChoServer.class.getName() + " started and listen on " + f.channel().localAddress()); f.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws InterruptedException {
        new EChoServer(8081).start();
    }
}
