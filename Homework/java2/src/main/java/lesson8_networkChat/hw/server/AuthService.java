package lesson8_networkChat.hw.server;

public interface AuthService {

    void start();
    String getNickByLoginPass(String login, String pass);
    void stop();
}
