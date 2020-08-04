package ru.meretskiy.homework16_consoleChat.client;

import java.io.*;
import java.net.Socket;

public class ConsoleChatClient {

    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8189;

    public void startClient() {

        try (Socket socket = new Socket(SERVER_ADDR, SERVER_PORT)) {

            System.out.println("Connected to server: " + SERVER_ADDR);
            System.out.println("Write you messages:");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String message = in.readUTF();
                            if (message.equals("/end")) {
                                break;
                            }
                            System.out.println("Server: " + message);
                        }
                    } catch (IOException exception) {
                        System.out.println("End session...");
                    }
                }
            }).start();

            while (true) {
                String message = reader.readLine();
                out.writeUTF(message);
            }

        } catch (IOException exc) {
            System.out.println("Close chat...");
        }
    }
}