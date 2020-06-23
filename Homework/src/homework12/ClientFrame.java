package homework12;

import javax.swing.*;
import java.awt.*;

public class ClientFrame extends JFrame {

    public ClientFrame() {

        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(700, 300, 500, 500);
        setLayout(new BorderLayout());

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        add(textPanel, BorderLayout.CENTER);

        JPanel enterPanel = new JPanel();
        enterPanel.setBackground(new Color(5, 175, 5));
        enterPanel.setLayout(new BorderLayout());
        add(enterPanel, BorderLayout.SOUTH);

        JTextArea textArea = new JTextArea();
        textArea.setEnabled(false);
        textPanel.add(textArea, BorderLayout.CENTER);

        JScrollPane ScrollPane = new JScrollPane(textArea);
        textPanel.add(ScrollPane);

        JTextField textField = new JTextField();
        enterPanel.add(textField, BorderLayout.CENTER);
        textField.addActionListener(new TextListener(textField, textArea));

        JButton button = new JButton("Enter");
        enterPanel.add(button, BorderLayout.EAST);
        button.addActionListener(new TextListener(textField, textArea));

        setVisible(true);
    }
}
