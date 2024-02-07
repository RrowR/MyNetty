package com.study.gupao.proxy.optimize;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * atlan 23:29
 */
@Slf4j
public class MyProxyClientHandler extends SimpleChannelInboundHandler<String> {

    // 服务端的ctx
    private ChannelHandlerContext ctx;

    public MyProxyClientHandler(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 服务端把消息发送回去了
        this.ctx.writeAndFlush(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("server里的client连接上了");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("server里的client断开了");
    }
}
