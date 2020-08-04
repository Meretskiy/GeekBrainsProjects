package ru.meretskiy.homework16_consoleChat.server;

public interface AuthService {

    void start();
    String getNickByLoginPass(String login, String pass);
    void stop();
}
