package com.study.gzll.client;

import com.study.lxdm.util.LogWriter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: atlan
 * @Date: 2022/1/6 12:49 上午
 */
public class MyClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        LogWriter.logger.info("client 收到了{}", msg);
    }
}
