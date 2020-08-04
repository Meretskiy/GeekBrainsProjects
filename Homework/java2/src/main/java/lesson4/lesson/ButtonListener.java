package lesson4.lesson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final JTextField textField;
    /**
     * Это глобальный компонент-родитель. Нужен чтобы вернуть ему фокус, после нажатия кнопки мышью,
     * поскольку он будет потерян и переведен на кнопку, которая была нажати
     */
    private final JFrame parent;

    public ButtonListener(JTextField textField, JFrame parent) {
        this.textField = textField;
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton current = (JButton) e.getSource();
        StringBuilder sb = new StringBuilder(textField.getText());
        sb.append(current.getText());
        textField.setText(sb.toString());
        /**
         * Возврат фокус компоненте-родителю
         * Если этого не сделать, то фокус будет потерян и глобальный слушатель клавиатуры
         * перестанет реагировать на нажатие кнопок на клавиатуре
         */
        parent.requestFocus();
    }
}
