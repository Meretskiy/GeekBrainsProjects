package ru.meretskiy.homework14_networksConsoleChatClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ConsoleChatServer {

    private static final int SERVER_PORT = 8189;

    public static void main(String[] args) {

        new ConsoleChatServer().startServer();
    }

    public synchronized void startServer() {

        Socket socket = null;

        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server start, white connect...");
            socket = serverSocket.accept();
            System.out.println("Client connected to port : " + SERVER_PORT);
            System.out.println("Write you messages:");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String message = reader.readLine();
                            out.writeUTF(message);
                        }
                    } catch (IOException exc) {
                        System.out.println("Close server...");
                    }
                }
            }).start();

            while (true) {
                String message = in.readUTF();
                if (message.equals("/end")) {
                    System.out.println("Client disconnected...");
                    break;
                }
                System.out.println("Client : " + message);
            }

        } catch (IOException exc) {
            System.out.println("End session...");
        } finally {
            try {
                socket.close();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}
