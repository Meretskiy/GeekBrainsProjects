package lesson8_networkChat.GoogleCalc2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Calculator 2.0");
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();
    }
}
class CalculatorPanel extends JPanel {
    public CalculatorPanel() {
        setLayout(new BorderLayout());

        result = 0;
        lastCommand = "=";
        start = true;

        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 5));
        addButton("", command);
        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("", command);
        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("", command);
        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("Cl", command);
        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);
    }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

    private class InsertAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }

    private class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (start) {
                if (command.equals("Cl")) {
// display.setText(command);
                    display.setText("");
                    start = false;
                } else lastCommand = command;
            } else {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }

    public void calculate(double x) {

        switch (lastCommand)
        {
            case "+": result=Math.rint((result + x)*100)/100; break;
            case "-": result=Math.rint((result - x)*100)/100; break;
            case "*": result=Math.rint((result * x)*100)/100; break;
            case "/": result=Math.rint((result / x)*100)/100; break;
            case "=": result = x; break;

        }
        display.setText("" + result);
    }

    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;
}
