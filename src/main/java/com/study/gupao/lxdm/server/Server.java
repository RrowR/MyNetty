package com.study.gupao.lxdm.server;


import com.study.gupao.lxdm.server.codec.OrderFrameDecoder;
import com.study.gupao.lxdm.server.codec.OrderFrameEecoder;
import com.study.gupao.lxdm.server.codec.OrderProtocolDecoder;
import com.study.gupao.lxdm.server.codec.OrderProtocolEncoder;
import com.study.gupao.lxdm.server.handler.OrderServerProcessHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.ExecutionException;

/**
 * atlan 19:24
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.channel(NioServerSocketChannel.class);

            serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));
            NioEventLoopGroup boss = new NioEventLoopGroup();
            NioEventLoopGroup worker = new NioEventLoopGroup();
            serverBootstrap.group(boss, worker);
            // 设置处理器
            serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    // 从 NioServerSocketChannel 获得 ChannelPipeline
                    ChannelPipeline pipeline = ch.pipeline();

                    pipeline.addLast(new OrderFrameDecoder());
                    pipeline.addLast(new OrderFrameEecoder());

                    pipeline.addLast(new OrderProtocolEncoder());
                    pipeline.addLast(new OrderProtocolDecoder());

                    pipeline.addLast(new LoggingHandler(LogLevel.INFO));

                    pipeline.addLast(new OrderServerProcessHandler());
                }
            });
            ChannelFuture channelFuture = serverBootstrap.bind(8091).sync();
            channelFuture.channel().closeFuture().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
