package lesson6_networks.lesson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        new Server().start();
    }

    public void start() {
        Socket socket;

        // try-with-resources block
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println(serverSocket.getInetAddress().toString());
            System.out.println(serverSocket.getLocalPort());

            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();

            System.out.println("Клиент подключился");
            System.out.println(socket.toString());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String str = in.readUTF();
                if (str.equals("/end")) {
                    break;
                }
                out.writeUTF("Эхо: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Клиент отключился");
        }
    }
}
