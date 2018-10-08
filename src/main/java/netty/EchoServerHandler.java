/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 *
 * @author fayuan.fzw
 * @version $Id: EchoServerHandler.java, v 0.1 2018年10月05日 下午10:05 fayuan.fzw Exp $
 */

@Sharable
//标识一个ChannelHandler可以被多个Channel安全的共享
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    /**
     * 对于每个传入的消息都需要调用
     *
     * */
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        System.out.println("server received: " + in.toString(CharsetUtil.UTF_8));

        //将接收到的消息写给发送者，而不冲刷出站消息
        channelHandlerContext.write(in);
    }

    @Override
    /**
     * 通知ChannelHandlerAdapter最后一次对channelRead()的调用是当前批次读取中最后一条消息
     *
     * */
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {

        //将未决消息冲刷到远程节点，并且关闭Channel
        channelHandlerContext.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    /**
     * 读取出现异常的时候调用
     *
     * */
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable cause) throws Exception {
        cause.printStackTrace();

        //关闭Channel
        channelHandlerContext.close();
    }

}