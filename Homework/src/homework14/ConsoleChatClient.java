package homework14;


import java.io.*;
import java.net.Socket;

public class ConsoleChatClient {

    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    public static void main(String[] args) {

        new ConsoleChatClient().startClient();
    }

    public synchronized void startClient() {

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
                                System.out.println("Server disconnected...");
                                socket.close();
                                break;
                            }
                            System.out.println("Server: " + message);
                        }
                    } catch (IOException exc) {
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