package lesson6_networks.lesson;

public class Networks {
    public static void main(String[] args) {
        // Будет с ошибкой, в какой-то момент заблокируется
        new Thread(() -> new Server().start()).start();
        new Thread(() -> new Client().start()).start();
    }
}
