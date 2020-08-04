package lesson6_networks.hw.versionTwo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

public class SentMessage implements Runnable{

    BufferedReader reader;
    DataOutputStream out;

    public SentMessage(BufferedReader reader, DataOutputStream out) {
        this.reader = reader;
        this.out = out;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = reader.readLine();
                out.writeUTF(message);
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
