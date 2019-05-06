package com.longtech.mqtt.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;

import java.util.List;

/**
 * Created by kaiguo on 2019/4/18.
 */
public class ByteBufToWebSocketFrameEncoder extends MessageToMessageEncoder<ByteBuf> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> out) throws Exception {
        if (byteBuf == null) {
            return;
        }
        BinaryWebSocketFrame result = new BinaryWebSocketFrame();
        result.content().writeBytes(byteBuf);
        out.add(result);
    }
}