package lesson8_networkChat.hw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame {
    private double result;
    private String lastCommand;
    private boolean start;
    private JTextField jtf;
    private JPanel jPanelBottom;

    public CalculatorFrame() {
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(800, 320, 250, 320);
        setResizable(false);

        result = 0;
        lastCommand = "=";
        start = true;

        initComponents();
    }

    private void initComponents() {
        JPanel jPanelMaster = new JPanel();
        jPanelMaster.setLayout(new BorderLayout());
        add(jPanelMaster);

        JPanel jPanelTop = new JPanel();
        jPanelMaster.add(jPanelTop, BorderLayout.NORTH);

        jPanelBottom = new JPanel();
        jPanelBottom.setLayout(new GridLayout(4, 4));
        jPanelMaster.add(jPanelBottom, BorderLayout.CENTER);

        jtf = new JTextField("0", 6);
        jtf.setFont(new Font("Arial", Font.PLAIN, 30));
        jtf.setHorizontalAlignment(JTextField.RIGHT);
        jtf.setEnabled(false);
        jPanelTop.add(jtf);

        JButton jbAC = new JButton("AC");
        jbAC.setPreferredSize(new Dimension(60, 60));
        jPanelTop.add(jbAC);
        jbAC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("");
            }
        });

        ActionListener insert = new Insert();
        ActionListener command = new Command();

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);
        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);
        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);
        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        setVisible(true);
    }

    private void addButton(String name, ActionListener actionListener) {
        JButton jb = new JButton(name);
        jb.addActionListener(actionListener);
        jPanelBottom.add(jb);
    }

    private class Insert implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();
            if (start) {
                jtf.setText("");
                start = false;
            }
            jtf.setText(jtf.getText() + input);
        }
    }

    private class Command implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (start) {
                if (command.equals("Cl")) {
                    jtf.setText("");
                    start = false;
                } else {
                    lastCommand = command;
                }
            } else {
                doCalculate(Double.parseDouble(jtf.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }

    public void doCalculate(double x) {
        switch (lastCommand) {
            case "+": {
                result += x;
                break;
            }
            case "-": {
                result -= x;
                break;
            }
            case "*": {
                result *= x;
                break;
            }
            case "/": {
                result /= x;
                break;
            }
            case "=": {
                result = x;
                break;
            }
        }

        jtf.setText("" + result);
    }

}
