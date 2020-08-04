package lesson6_networks.hw.versionTwo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ConsoleChatServer {

    private final int SERVER_PORT = 8189;

    public static void main(String[] args) {

        new ConsoleChatServer().startServer();
    }

    public void startServer() {

        Socket socket = null;

        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server start, white connect...");
            socket = serverSocket.accept();
            System.out.println("Client connected.");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            new Thread (new SentMessage(reader, out)).start();
            new Thread (new AcceptMessage(in)).start();


        } catch (IOException exc) {
            exc.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}
