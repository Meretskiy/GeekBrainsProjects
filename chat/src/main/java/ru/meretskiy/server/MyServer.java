package ru.meretskiy.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer {

    private final int PORT = 8189;
    private List<ClientHandler> clients;
    private AuthService authService;
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private static final Logger logger = LogManager.getLogger(MyServer.class);

    public AuthService getAuthService() {
        return authService;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public MyServer() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            authService = new BaseAuthService();
            authService.start();
            clients = new ArrayList<>();
            while (true) {
                logger.info("Server waiting connecting...");
                Socket socket = server.accept();
                logger.info("Client connected...");
                new ClientHandler(this, socket);
            }
        } catch (IOException exc) {
            logger.warn("Server error! ", exc);
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
        logger.info(msg);
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

    public synchronized void privateMsg(ClientHandler currentClient, String distClient, String msg) {
        logger.info(msg);
        for (ClientHandler o : clients) {
            if (distClient.equalsIgnoreCase(o.getName())) {
                o.sendMsg("[" + currentClient.getName() + "] to [" + distClient + "] : " + msg);
                currentClient.sendMsg("[" + currentClient.getName() + "] to [" + distClient + "] : " + msg);
                return;
            }
        }
        currentClient.sendMsg("Client " + distClient + " does not exist...");
    }

    public synchronized void unsubscribe(ClientHandler o) {
        clients.remove(o);
    }

    public synchronized void subscribe(ClientHandler o) {
        clients.add(o);
    }
}
