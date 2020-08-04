package lesson8_networkChat.lesson;

import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {
    public Form(String title) {
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(50, 35, 300, 300);
        setVisible(true);


//        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLayout(new FlowLayout());

        for (int i = 1; i <= 20; i++) {
            JButton jb = new JButton();
            jb.setText("Button #" + i);
            jb.setSize(50, 50);
            add(jb);
        }

//        JTextArea jta = new JTextArea("Write down some text...");
//        add(jta);

//        JButton jb1 = new JButton("#1");
//        JButton jb2 = new JButton("#2");
//        JButton jb3 = new JButton("#3");
//        JButton jb4 = new JButton("#4");
//        JButton jb5 = new JButton("#5");
//
//        setLayout(new BorderLayout());
//        add(jb1, BorderLayout.CENTER);
//        add(jb2, BorderLayout.EAST);
//        add(jb3, BorderLayout.WEST);
//        add(jb4, BorderLayout.SOUTH);
//        add(jb5, BorderLayout.NORTH);

        getGraphics().drawRect(50, 50, 500, 500);
    }
}
