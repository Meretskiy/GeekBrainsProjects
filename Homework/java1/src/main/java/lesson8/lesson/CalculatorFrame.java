package lesson8.lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame(String title) {
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(50, 35, 300, 300);
        setVisible(true);

        setLayout(new GridLayout(4, 3));

        JTextField jtf = new JTextField("Result...");
        add(jtf);

        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '+', '9', '='};
        for (int i = 0; i < chars.length; i++) {
            JButton jb = new JButton(String.valueOf(chars[i]));
            jb.addActionListener(new ButtonListener(jtf));
            add(jb);
        }

        JButton singleBtn = new JButton("Single");
        singleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(new Color(0x051607));
                System.out.println("Clicked on single button");
            }
        });
        add(singleBtn);
    }
}
