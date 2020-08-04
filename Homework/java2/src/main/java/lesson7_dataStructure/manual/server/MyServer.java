package lesson7_dataStructure.manual.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * MyServer хранит список подключенных клиентов, предназначенный для
 * управления соединением с клиентом и рассылкой сообщений.
 * При подключении и авторизации клиент добавляется в этот список (через метод
 * subscribe()), при отключении — удаляется (через unsubscribe()). Для блокировки
 * возможности авторизоваться нескольким клиентам под одной учётной записью
 * используется метод isNickBusy(), проверяющий занятость ника в текущем сеансе чата.
 */

public class MyServer {

    private final int PORT = 8189;
    private List<ClientHandler> clients;
    private AuthService authService;

    public AuthService getAuthSevrice() {
        return authService;
    }

    public MyServer() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            authService = new BaseAuthService();
            authService.start();
            clients = new ArrayList<>();
            while (true) {
                System.out.println("Server waiting connecting...");
                Socket socket = server.accept();
                System.out.println("Client connected...");
                new ClientHandler(this, socket);
            }
        } catch (IOException exc) {
            System.out.println("Server error!");
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public synchronized boolean isNickBusy(String nick) {
        for (ClientHandler o : clients) {
            if (o.getName().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void broadcastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

    public synchronized void unsubscribe(ClientHandler o) {
        clients.remove(o);
    }

    public synchronized void subscribe(ClientHandler o) {
        clients.add(o);
    }
}
