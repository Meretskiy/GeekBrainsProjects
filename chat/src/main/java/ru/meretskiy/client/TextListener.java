package ru.meretskiy.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;

public class TextListener implements ActionListener {

    private JTextField textField;
    private DataOutputStream out;

    public TextListener(JTextField textField, DataOutputStream out) {
        this.textField = textField;
        this.out = out;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sendMsg(textField.getText());
        textField.setText("");
    }

    private void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
