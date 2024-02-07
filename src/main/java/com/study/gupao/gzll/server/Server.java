package com.study.gupao.gzll.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultThreadFactory;

/**
 * @Author: atlan
 * @Date: 2022/1/6 12:33 上午
 * <p>
 * 跟踪链路
 */
public class Server {
    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);
        // 指定线程名字
        NioEventLoopGroup boss = new NioEventLoopGroup(1, new DefaultThreadFactory("boss"));
        NioEventLoopGroup worker = new NioEventLoopGroup(8, new DefaultThreadFactory("worker"));
        serverBootstrap.group(boss, worker);
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new LoggingHandler(LogLevel.DEBUG));
                pipeline.addLast("myencoder", new StringEncoder());
                pipeline.addLast(new StringDecoder());
                pipeline.addLast("handler", new MyServerHandler());
            }
        });
        ChannelFuture channelFuture = serverBootstrap.bind(23334).sync();
        channelFuture.channel().closeFuture().sync();
    }
}
