package com.flamexander.netty.servers.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/* чтобы Handler был входящим или исходящим мы наследуем его либо от ChannelInboundHandler, либо от ChannelOutboundHandler
 * Если наследоваться напрямую от них, нужно будет переопределить кучу методов, не всегда нужных.
 * По этому обычно наследуются от Адаптреа, где уже есть стандартые реализации методов
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /* обработчик событий. Когда приходит сообщение в хендлере срабатывает этот метод. В параметрах передается
     * ссылка на контекст(информация о сетевом соединении, ссылка на сокет канал, конвеер и т.д.) и входящее сообщение
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Received and released"); //действия
        ((ByteBuf) msg).release(); //далеам релиз, освобождаем буфер.
    }

    /* Обязательный метод перехвата исключений. Без него если посылка на придет на сервер не распечатется ексепшен и
     * мы даже не поймем почему посылка не дошла.
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace(); //печатаем причину исключения
        ctx.close(); //закрываем контекст
    }

/*
    Пример простейшего чтения.
    Так как наш хендлер стоит первым от сети, нам обязательно подадут БайтБуф
 */
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf in = (ByteBuf) msg; //делаем каст к БайтБуф, обязательно Неттевский не Иошный
//        try {
//            while (in.isReadable()) {                   //до тех пор пока в БайтБуф есть что то, что мы не прочитали
//                System.out.print((char) in.readByte()); //мы вычитываем побайтово эти данные и печатаем в консоль
//            }
//        } finally {
//            in.release(); //делаем резил и нетти чистит буфер. Если его не делать, может начать утекать память
//        }
//  }
}
