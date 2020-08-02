package ru.meretskiy.server;

public interface AuthService {

    void start();
    void stop();
    String getNick(String login, String pass);
    String changeNick(String nick, String newNick);
}
