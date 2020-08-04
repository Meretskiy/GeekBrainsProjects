package lesson6.lesson;

public class MainClass {

    public static void main(String[] args) {

        FlyMashine flyMashine = new FlyMashine("pttp1");
        flyMashine.fly();

        Airplane airplane = new Airplane();
        airplane.fly();
    }
}
