package com.flamexander.netty.servers.discard;

import io.netty.bootstrap.ServerBootstrap;

import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DiscardServer {
    public void run() throws Exception {

        //пулы потоков Netty, аналог ExecutorService
        EventLoopGroup bossGroup = new NioEventLoopGroup(); //пул потоков предназначенный для обработки входящих подключений
        EventLoopGroup workerGroup = new NioEventLoopGroup(); //основной пул потоков занимающийся сетевой частью, получить данные, отправидь данные и т.д.
        try {
            ServerBootstrap b = new ServerBootstrap(); //настройка работы сервера
            b.group(bossGroup, workerGroup) //указываем пулы потоков
                    .channel(NioServerSocketChannel.class) //для подключения клиентов используем канал NioServerSocketChannel аналог ServerSocket в IO
                    .childHandler(new ChannelInitializer<SocketChannel>() { //настройка конвеера, для каждого клиента свой. Когда клиент подключается мы должны его проинициализировать
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new DiscardServerHandler()); //и в конвеер клиента добавляем один квадратик(Handler) в данном случае DiscardServerHandler
                        }
                    });
//                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture f = b.bind(8189).sync(); //запускаем сервер на определенном порту
            f.channel().closeFuture().sync(); //ожидаем завершение работы сервера
        } finally {
            workerGroup.shutdownGracefully(); //закрытие пула потоков
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new DiscardServer().run();
    }
}
