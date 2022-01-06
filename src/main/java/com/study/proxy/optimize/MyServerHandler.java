package com.study.proxy.optimize;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: atlan
 * @Date: 2022/1/6 12:41 上午
 */
@Slf4j
public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    private AtomicLong atomicLong = new AtomicLong(0);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(ctx.channel().eventLoop())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new StringEncoder());
                        pipeline.addLast(new MyProxyClientHandler(ctx));
                    }
                });
        ChannelFuture clientFuture = bootstrap.connect("127.0.0.1", 23334);
        clientFuture.addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()){
                // 调用客户端的发送消息给23334端口服务器
                future.channel().writeAndFlush(msg + atomicLong.incrementAndGet());
            }
        });

    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("服务器连接成功(●'◡'●)！！！");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("服务器连接已断开/(ㄒoㄒ)/~~");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
