package com.flamexander.netty.servers.serialization;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class CloudServerHandler extends ChannelInboundHandlerAdapter {
    //печатаем информацию о том когда клиент подключился
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client connected...");
    }

    //печатаем информацию когда клиент отключился
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client disconnected...");
    }

    //когда прилетает объект распечатываем тип этого объекта, если это маймесседж распечатывем
    //месседж и отправляем ответку.
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg.getClass().getName());
        if (msg instanceof MyMessage) {
            System.out.println("Client text message: " + ((MyMessage) msg).getText());
            ctx.writeAndFlush(new MyMessage("Hello Client!"));
        } else {
            System.out.printf("Server received wrong object!");
        }
    }

    //перехватываем исключения
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
