package com.study.lxdm.client.codec;

import com.study.lxdm.common.Operation;
import com.study.lxdm.common.RequestMessage;
import com.study.lxdm.util.IdUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * atlan 22:33
 */
public class OperationToRequestMessageEncoder extends MessageToMessageEncoder<Operation> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Operation msg, List<Object> out) throws Exception {
        RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(), msg);
        out.add(requestMessage);
    }
}
