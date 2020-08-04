package lesson6_networks.hw.versionTwo;

import java.io.*;
import java.net.Socket;

public class ConsoleChatClient {

    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    public static void main(String[] args) {

        new ConsoleChatClient().startClient();
    }

    public void startClient() {

        try (Socket socket = new Socket(SERVER_ADDR, SERVER_PORT)) {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            new Thread (new SentMessage(reader, out)).start();
            new Thread (new AcceptMessage(in)).start();

        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}