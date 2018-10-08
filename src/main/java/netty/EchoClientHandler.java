/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 *
 * @author fayuan.fzw
 * @version $Id: EchoClientHandler.java, v 0.1 2018年10月06日 上午12:20 fayuan.fzw Exp $
 */
public class EchoClientHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
    }

    public void channelRead(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("client received: " + msg.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}