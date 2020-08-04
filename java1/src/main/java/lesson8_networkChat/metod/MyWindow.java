package lesson8_networkChat.metod;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("My first window in Java!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 500, 400, 300);

//        JButton[] jbs = new JButton[5];
//        for (int i = 0; i < jbs.length; i++) {
//            jbs[i] = new JButton("#" + i);
//        }
//        setLayout(new BorderLayout());
//        add(jbs[0], BorderLayout.EAST);
//        add(jbs[1], BorderLayout.WEST);
//        add(jbs[2], BorderLayout.SOUTH);
//        add(jbs[3], BorderLayout.NORTH);
//        add(jbs[4], BorderLayout.CENTER);
//        setVisible(true);

//        JButton button = new JButton("Button1 (PAGE_START)");
//        add(button, BorderLayout.PAGE_START);
//
//        button = new JButton("Button 2 (CENTER)");
//        button.setPreferredSize(new Dimension(200, 100));
//        add(button, BorderLayout.CENTER);
//
//        button = new JButton("Button 3 (LINE_START)");
//        add(button, BorderLayout.LINE_START);
//
//        button = new JButton("Button 4 (PAGE_END)");
//        add(button, BorderLayout.PAGE_END);
//
//        button = new JButton("5 (LINE_END)");
//        add(button, BorderLayout.LINE_END);
//
//        setVisible(true);

//        JButton[] jbs = new JButton[10];
//        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
////        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
//        for (int i = 0; i < jbs.length; i++) {
//            jbs[i] = new JButton("#" + i);
//            jbs[i].setAlignmentX(CENTER_ALIGNMENT);
//            add(jbs[i]);
//        }
//        setVisible(true);

//        JButton[] jbs = new JButton[10];
//        setLayout(new FlowLayout());
//        for (int i = 0; i < jbs.length; i++) {
//            jbs[i] = new JButton("#" + i);
//            add(jbs[i]);
//        }
//        setVisible(true);

//        JButton[] jbs = new JButton[12];
//        setLayout(new GridLayout(4, 3));
//        for (int i = 0; i < jbs.length; i++) {
//            jbs[i] = new JButton("#" + i);
//            add(jbs[i]);
//        }
//        setVisible(true);

        JButton button = new JButton("Button");
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button pressed...");
            }
        });
        setVisible(true);

//        JTextField field = new JTextField();
//        add(field);
//        field.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Yous message!" + field.getText());
//            }
//        });
//        setVisible(true);

//        JPanel panel = new JPanel();
//        add(panel);
//        panel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                System.out.println("MousePos: " + e.getX() + " " + e.getY());
//            }
//        });
//        setVisible(true);


    }
}
