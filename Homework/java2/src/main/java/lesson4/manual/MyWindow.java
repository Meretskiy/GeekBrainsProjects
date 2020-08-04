package lesson4.manual;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    public MyWindow() {

        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        JButton jb1 = new JButton("EAST");
        JButton jb2 = new JButton("WEST");
        JButton jb3 = new JButton("SOUTH");
        JButton jb4 = new JButton("NORTH");
        JButton jb5 = new JButton("CENTER");
        JButton jb6 = new JButton("CENTER2");

        setLayout(new BorderLayout());

        add(jb1, BorderLayout.EAST);
        add(jb2, BorderLayout.WEST);
        add(jb3, BorderLayout.SOUTH);
        add(jb4, BorderLayout.NORTH);
        add(jb5, BorderLayout.CENTER);
        add(jb6, BorderLayout.PAGE_END);

        setVisible(true);
    }
}
