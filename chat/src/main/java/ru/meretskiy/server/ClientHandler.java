package ru.meretskiy.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private MyServer myServer;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private static final Logger logger = LogManager.getLogger(ClientHandler.class);

    private String name;

    public String getName() {
        return name;
    }

    public ClientHandler(MyServer myServer, Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";
            myServer.getExecutorService().execute(() -> {
                try {
                    Thread thread = new Thread(() -> {
                        try {
                            authentication();
                        } catch (IOException exception) {
                            logger.warn(exception);
                        }
                    });
                    thread.setDaemon(true);
                    thread.start();
                    long endTimeMillis = System.currentTimeMillis() + 120000;
                    while (thread.isAlive()) {
                        if (System.currentTimeMillis() > endTimeMillis) {
                            logger.info("Time authentication out...");
                            closeConnection();
                            return;
                        }
                    }
                    readMessage();
                } catch (IOException e) {
                    logger.warn(e);
                } finally {
                    closeConnection();
                }
            });
        } catch (IOException e) {
            logger.warn("Problems in create client...", e);
        }
    }

    public void authentication() throws IOException {
        while (true) {
            String str = in.readUTF();
            if (str.startsWith("/auth ")) {
                String[] parts = str.split("\\s");
                String nick =
                        myServer.getAuthService().getNick(parts[1], parts[2]);
                if (nick != null) {
                    if (!myServer.isNickBusy(nick)) {
                        sendMsg("/authok " + nick);
                        name = nick;
                        myServer.broadcastMsg(name + " enter chat");
                        myServer.subscribe(this);
                        return;
                    } else {
                        sendMsg("Nick is busy...");
                    }
                } else {
                    sendMsg("Invalid login/pass");
                }
            }
        }
    }

    public void readMessage() throws IOException {
        while (true) {
            String strFromClient = in.readUTF();
            logger.info(String.format("from %s : %s", name, strFromClient));

            if (strFromClient.equals("/end ")) {
                break;
            }

            if (strFromClient.startsWith("/w ")) {
                checkPrivateMessage(strFromClient);
            } else {
                myServer.broadcastMsg(name + " : " + strFromClient);
            }

            if (strFromClient.startsWith("/changeNick ")) {
                String[] parts = strFromClient.split("\\s");
                String newNick = myServer.getAuthService().changeNick(name, parts[1]);
                if (newNick != null) {
                    sendMsg("/changeOk ");
                    name = newNick;
                } else {
                    sendMsg("/changeFail ");
                }
            }
            continue;
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
            logger.info(msg);
        } catch (IOException e) {
            logger.warn(e);
        }
    }

    private void checkPrivateMessage(String msg) {
        String[] prvMsg = msg.split("\\s", 3);
        myServer.privateMsg(this, prvMsg[1], prvMsg[2]);
    }

    public void closeConnection() {
        myServer.unsubscribe(this);
        myServer.broadcastMsg(name + " exit chat");
        try {
            in.close();
        } catch (IOException e) {
            logger.warn(e);
        }
        try {
            out.close();
        } catch (IOException e) {
            logger.warn(e);
        }
        try {
            socket.close();
        } catch (IOException e) {
            logger.warn(e);
        }
    }
}
