package ru.meretskiy.homework16.server;

public interface AuthService {

    void start();
    String getNickByLoginPass(String login, String pass);
    void stop();
}
