package lesson8_networkChat.lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private JTextField jTextField;

    public ButtonListener(JTextField jTextField) {
        this.jTextField = jTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        jTextField.setText(jButton.getText());
        jButton.setBackground(new Color(236, 5, 244));
        jButton.setText("Gotcha!");
    }
}
