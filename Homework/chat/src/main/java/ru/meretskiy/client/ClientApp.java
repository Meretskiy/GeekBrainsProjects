package ru.meretskiy.client;

public class ClientApp {

    public static void main(String[] args) {

        new Thread(() -> new ConsoleChatClient().startClient()).start();

    }
}
