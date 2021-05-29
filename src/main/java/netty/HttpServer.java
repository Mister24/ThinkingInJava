/**
 * fzw.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 *
 * @author fzw.fzw
 * @version $Id: HttpServer.java, v 0.1 2018年09月28日 下午9:43 fzw.fzw Exp $
 */
public class HttpServer {

    private int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: " + HttpServer.class.getSimpleName() + "<port>");
            return;
        }

        int port = Integer.parseInt(args[0]);
        new HttpServer(port).start();
    }

    public void start() throws Exception {
        final EchoServerHandler serverHandler = new EchoServerHandler();

        //创建EventLoopGroup
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        EventLoopGroup workerLoopGroup = new NioEventLoopGroup();

        try {

            //创建ServerBootstrap
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            //指定使用NIO方式完成
            serverBootstrap.group(eventLoopGroup, workerLoopGroup)
                    .channel(NioServerSocketChannel.class)

                    //使用网络序的port
                    .localAddress(new InetSocketAddress(port))

                    //添加一个EchoServerHandler到子Channel的ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        public void initChannel(SocketChannel socketChannel) throws Exception {

                            //EchoServerHandler被标记为@Sharable，所以我们可以总是使用同样的实例
                            socketChannel.pipeline().addLast(serverHandler);
                        }
                    })
            .option(ChannelOption.SO_BACKLOG, 128)
            .childOption(ChannelOption.SO_KEEPALIVE, true);
            ;

            //异步绑定服务器，调用sync()阻塞方式完成
            ChannelFuture channelFuture = serverBootstrap.bind().sync();

            //获取Channel的CloseFuture，调用sync()阻塞方式完成
            channelFuture.channel().closeFuture().sync();
        } finally {

            workerLoopGroup.shutdownGracefully().sync();
            //释放EventLoopGroup资源
            eventLoopGroup.shutdownGracefully().sync();
        }
    }
}