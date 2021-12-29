package com.study.lxdm.client.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * atlan 18:56
 */
public class OrderFrameDecoder extends LengthFieldBasedFrameDecoder {
    public OrderFrameDecoder() {
        super(Integer.MAX_VALUE, 0, 2, 0, 2);
    }
}
