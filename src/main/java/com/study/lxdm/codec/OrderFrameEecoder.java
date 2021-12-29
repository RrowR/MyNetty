package com.study.lxdm.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * atlan 18:56
 */
public class OrderFrameEecoder extends LengthFieldPrepender {
    public OrderFrameEecoder() {
        super(2);
    }
}
