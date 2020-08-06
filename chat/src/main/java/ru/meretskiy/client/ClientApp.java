package ru.meretskiy.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientApp {

    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8189;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static Socket socket;

    private static void startClient() {

        try {
           socket = new Socket(SERVER_ADDR, SERVER_PORT);
           in = new DataInputStream(socket.getInputStream());
           out = new DataOutputStream(socket.getOutputStream());
           ClientFrame clientFrame = new ClientFrame(in, out);
        } catch (IOException e) {
            e.printStackTrace();
            closeConnection();
        }
    }

    private static void closeConnection() {

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        startClient();
    }
}
