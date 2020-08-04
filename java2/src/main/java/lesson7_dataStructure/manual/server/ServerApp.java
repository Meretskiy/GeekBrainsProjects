package lesson7_dataStructure.manual.server;

/**
 * Серверная часть состоит из:
 * ● ServerApp — основной класс, содержащий метод main() и запускающий сервер.
 * ● MyServer — класс, представляющий собой сервер.
 * ● ClientHandler — класс, отвечающий за обмен сообщениями между клиентами и сервером.
 * ● AuthService — интерфейс, описывающий сервис аутентификации на стороне сервера.
 * ● BaseAuthService — класс, реализующий аутентификацию клиента через обычный список
 * клиентов.
 */

public class ServerApp {

    public static void main(String[] args) {

       new MyServer();
    }
}
