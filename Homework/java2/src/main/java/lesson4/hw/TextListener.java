package lesson4.hw;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextListener implements ActionListener {

    private JTextField textField;
    private JTextArea textArea;

    public TextListener(JTextField textField, JTextArea textArea) {
        this.textField = textField;
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String massage = String.format("%s\n[%s]: %s",
                textArea.getText(), dateFormat.format(date), textField.getText());
        textArea.setText(massage);
        textField.setText(null);
        textField.requestFocus();
    }
}
