package com.flamexander.netty.example.client;

import com.flamexander.netty.example.common.AbstractMessage;
import io.netty.handler.codec.serialization.ObjectDecoderInputStream;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;

import java.io.IOException;
import java.net.Socket;

/*
    Нетворк построим на статике
 */
public class Network {
    private static Socket socket; //сокет соединения с серваком
    private static ObjectEncoderOutputStream out; //энкодер, исходящий поток для отправки объектов
    private static ObjectDecoderInputStream in; //декодер, входящий поток для получения объектов

    //При старте мы подключемся к серваку, создаем два этих потока
    public static void start() {
        try {
            socket = new Socket("localhost", 8189);
            out = new ObjectEncoderOutputStream(socket.getOutputStream());
            in = new ObjectDecoderInputStream(socket.getInputStream(), 50 * 1024 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //стопаем все и закрываем
    public static void stop() {
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Позволяет отправлять любые сообщения серверу
    public static boolean sendMsg(AbstractMessage msg) {
        try {
            out.writeObject(msg);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Позволяет получать любые объекты от сервера. Сидим в блокирующей операции и ждем пока нам сервак что то не пришлет
    public static AbstractMessage readObject() throws ClassNotFoundException, IOException {
        Object obj = in.readObject();
        return (AbstractMessage) obj;
    }
}