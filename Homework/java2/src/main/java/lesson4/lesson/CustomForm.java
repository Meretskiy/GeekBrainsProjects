package lesson4.lesson;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CustomForm extends JFrame {
    public CustomForm() {
        setTitle("Second custom form");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0, 0, 500, 500);

        JPanel jPanel = new JPanel();
        JPanel jPanel2 = new JPanel();
        jPanel.setBackground(new Color(16245));
        jPanel2.setBackground(new Color(255, 255, 255));

        jPanel2.setLayout(new FlowLayout());
        JTextArea jTextArea = new JTextArea("JTextArea #1");
        JScrollPane scrollPane = new JScrollPane(jTextArea);
        jPanel2.add(scrollPane);


        setLayout(new GridLayout(2, 2));

        add(jPanel);
        add(jPanel2);

        setVisible(true);
    }

    private void applyCustomPosition() {
        List<JButton> jButtons = new ArrayList<>();
        JButton jButton = new JButton("#1");
        jButton.setBounds(0, 0, 50, 50);
        jButtons.add(jButton);

        JButton jButton1 = new JButton("#2");
        jButton1.setBounds(0, 60, 50, 50);
        jButtons.add(jButton1);

        JButton jButton2 = new JButton("#3");
        jButton1.setBounds(0, 110, 50, 50);
        jButtons.add(jButton2);

        JButton jButton3 = new JButton("#4");
        jButton1.setBounds(0, 160, 50, 50);;
        jButtons.add(jButton3);

        JButton jButton4 = new JButton("#5");
        jButton1.setBounds(0, 210, 50, 50);
        jButtons.add(jButton4);

        for (JButton jb : jButtons) {
            add(jb);
        }
    }

    private void applyFlowLayout() {
        setLayout(new FlowLayout());
        for (int i = 0; i < 10; i++) {
            add(new JButton("#" + (i + 1)));
        }
    }

    private void applyBoxLayout(List<JButton> jButtons) {
//        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        for (JButton jb : jButtons) {
            add(jb);
        }
    }

    private void applyBorderLayout(List<JButton> jButtons) {
        setLayout(new BorderLayout());
//        add(jButtons.get(0), BorderLayout.EAST);
//        add(jButtons.get(1), BorderLayout.WEST);
//        add(jButtons.get(2), BorderLayout.SOUTH);
//        add(jButtons.get(3), BorderLayout.NORTH);
//        add(jButtons.get(4), BorderLayout.CENTER);

        add(jButtons.get(0), BorderLayout.PAGE_START);
        add(jButtons.get(1), BorderLayout.PAGE_END);
        add(jButtons.get(2), BorderLayout.CENTER);
        add(jButtons.get(3), BorderLayout.LINE_START);
        add(jButtons.get(4), BorderLayout.LINE_END);
    }
}
