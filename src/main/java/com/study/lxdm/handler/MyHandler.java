package com.study.lxdm.handler;

import com.study.lxdm.common.Operation;
import com.study.lxdm.common.OperationResult;
import com.study.lxdm.common.RequestMessage;
import com.study.lxdm.common.ResponseMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * atlan 19:06
 */
public class MyHandler extends SimpleChannelInboundHandler<RequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestMessage requestMessage) throws Exception {
        Operation operation = requestMessage.getMessageBody();
        OperationResult result = operation.execute();
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessageHeader(requestMessage.getMessageHeader());
        responseMessage.setMessageBody(result);
        // 将信息写出去
        ctx.writeAndFlush(responseMessage);
    }
}
