package lesson7_dataStructure.manual.server;

public interface AuthService {

    void start();
    String getNickByLoginPass(String login, String pass);
    void stop();
}
