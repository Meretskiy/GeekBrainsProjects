package lesson4_Swing_chatGUI.lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class BrasilCalculatorForm extends JFrame {
    public BrasilCalculatorForm() {
        setTitle("Calculator");
        setBounds(0, 0, 500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new GridLayout(2, 1));

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        top.setBackground(new Color(242, 238, 2));
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(3, 3));
        bottom.setBackground(new Color(2, 222, 94));

        add(top);
        add(bottom);

        JTextField textField = new JTextField();
        textField.setEnabled(false);
        textField.setBounds(0, 0, 100, 50);
        add(textField);

        /**
         * Слушатель клавиатуры будет работать только с элементом, на котором стоит фокус
         * (к примеру, нажать физически на объект)
         * Но мы хотим чтобы слушатель был привязан к глобальной компоненте, потому
         * ставим ей значение focusable = true
         */
        setFocusable(true);
        /**
         * Добавляем слушатель клавиатуры к глобальной компоненте
         * Теперь при нажатии клавиши будет происходить обработка события
         */
        addKeyListener(new ButtonKeyListener(textField));

        ButtonListener buttonListener = new ButtonListener(textField, this);

        for (int i = 0; i <= 9; i++) {
            JButton jButton = new JButton(String.valueOf(i));
            jButton.addActionListener(buttonListener);
            bottom.add(jButton);
        }

        Set<String> symbols = new HashSet<>();
        symbols.add("+");
        symbols.add("-");
        symbols.add("/");
        symbols.add("*");
        symbols.add("=");
        symbols.add("C");

        for (String s : symbols) {
            JButton jButton = new JButton(s);
            bottom.add(jButton);

            if (s.equals("=")) {
                jButton.addActionListener(new CalculationListener(textField, this));
            } else if (s.equals("C")) {
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField.setText("");
                    }
                });
            } else {
                jButton.addActionListener(buttonListener);
            }
        }

        setVisible(true);
    }
}
