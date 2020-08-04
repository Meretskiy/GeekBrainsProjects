package lesson6_networks.hw.versionTwo;

import java.io.DataInputStream;
import java.io.IOException;

public class AcceptMessage implements Runnable{

    DataInputStream in;

    public AcceptMessage(DataInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = in.readUTF();
                if (message.equals("/end")) {
                    break;
                }
                System.out.println(message);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
