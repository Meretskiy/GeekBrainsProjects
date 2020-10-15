package com.flamexander.netty.example.server;

import com.flamexander.netty.example.common.AbstractMessage;
import com.flamexander.netty.example.common.FileMessage;
import com.flamexander.netty.example.common.FileRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.nio.file.Files;
import java.nio.file.Paths;

public class MainHandler extends ChannelInboundHandlerAdapter {
    /* Получаем готовый джавовский объект. В данном случае от клиента будем получать только файлРеквест.
       Клиент посылает серваку файлРеквест, сервак его получает, делает каст и говорит у меня есть серверСторадж
       в котором есть файлы 1, 2,3 и тд И если я вижу что такой файл у меня есть в серверСторадже , то тогда
       я по нему сформирую файлМесседж и отправлю клиенту. Файл месседж пролетает через инкодер  клиент его получает
       и пишет в файл например
    */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof FileRequest) {
            FileRequest fr = (FileRequest) msg;
            if (Files.exists(Paths.get("server_storage/" + fr.getFilename()))) {
                FileMessage fm = new FileMessage(Paths.get("server_storage/" + fr.getFilename()));
                ctx.writeAndFlush(fm);
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
