package com.study.lxdm.server;

import com.study.lxdm.codec.OrderFrameDecoder;
import com.study.lxdm.codec.OrderFrameEecoder;
import com.study.lxdm.codec.OrderProtocolDecoder;
import com.study.lxdm.codec.OrderProtocolEecoder;
import com.study.lxdm.handler.MyMsgHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.ExecutionException;

/**
 * atlan 19:24
 */
public class Server {
    public static void main(String[] args) {
        try {
            // 创建启动雷
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 设置协议模式
            serverBootstrap.channel(NioServerSocketChannel.class);
            // 设置日志
            serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));
            // 创建主从
            NioEventLoopGroup boss = new NioEventLoopGroup(1);
            NioEventLoopGroup worker = new NioEventLoopGroup(8);
            // 设置主从
            serverBootstrap.group(boss,worker);
            // 设置处理器
            serverBootstrap.childHandler(new ChannelInitializer<NioServerSocketChannel>() {
                @Override
                protected void initChannel(NioServerSocketChannel ch) throws Exception {
                    // 从 NioServerSocketChannel 获得 ChannelPipeline
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(new OrderFrameDecoder());
                    pipeline.addLast(new OrderProtocolDecoder());
                    pipeline.addLast(new OrderFrameEecoder());
                    pipeline.addLast(new OrderProtocolEecoder());
                    pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                    pipeline.addLast(new MyMsgHandler());
                }
            });
            ChannelFuture channelFuture = serverBootstrap.bind(8090).sync();
            channelFuture.channel().closeFuture().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
