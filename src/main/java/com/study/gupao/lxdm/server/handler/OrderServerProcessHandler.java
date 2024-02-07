package com.study.gupao.lxdm.server.handler;

import com.study.gupao.lxdm.common.Operation;
import com.study.gupao.lxdm.common.OperationResult;
import com.study.gupao.lxdm.common.RequestMessage;
import com.study.gupao.lxdm.common.ResponseMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * atlan 19:06
 */
public class OrderServerProcessHandler extends SimpleChannelInboundHandler<RequestMessage> {
    // 这里开始执行业务,监听发送过来的消息
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
