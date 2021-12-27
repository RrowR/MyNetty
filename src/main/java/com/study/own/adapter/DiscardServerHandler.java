package com.study.own.adapter;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
    自定义的服务处理器
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {        // (1)
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {   // (2)
        // 静默丢弃接收到的数据   ByteBuf 收到消息的类型
        ((ByteBuf) msg).release(); // (3)
    }

    // 通常也这么用
    // @Override
    // public void channelRead(ChannelHandlerContext ctx, Object msg) {
    //     try {
    //         // Do something with msg
    //     } finally {
    //         ReferenceCountUtil.release(msg);
    //     }
    // }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 引发异常时关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
