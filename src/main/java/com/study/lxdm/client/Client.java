package com.study.lxdm.client;

import com.study.lxdm.client.codec.*;
import com.study.lxdm.common.RequestMessage;
import com.study.lxdm.common.order.OrderOperation;
import com.study.lxdm.util.IdUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.ExecutionException;

/**
 * atlan 19:39
 */
public class Client {
    public static void main(String[] args) {
        try {
            // 创建启动类
            Bootstrap bootstrap = new Bootstrap();
            // 设置协议模式
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.group(new NioEventLoopGroup());
            // 设置处理器
            bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    // 从 NioServerSocketChannel 获得 ChannelPipeline
                    ChannelPipeline pipeline = ch.pipeline();

                    pipeline.addLast(new OrderFrameDecoder());
                    pipeline.addLast(new OrderFrameEecoder());

                    pipeline.addLast(new OrderProtocolEncoder());
                    pipeline.addLast(new OrderProtocolDecoder());

                    pipeline.addLast(new OperationToRequestMessageEncoder());

                    pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                }
            });
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1",8091);
            // 让他线挂起网下下执行
            channelFuture.sync();
            RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(), new OrderOperation(1001, "hello netty server!!!"));
            // OrderOperation orderOperation = new OrderOperation(1001, "hello netty server!!!");

            channelFuture.channel().writeAndFlush(requestMessage);
            channelFuture.channel().closeFuture().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
