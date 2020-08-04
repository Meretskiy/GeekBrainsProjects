package lesson4_Swing_chatGUI.lesson;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculationListener implements ActionListener {
    private final JTextField textField;
    private final JFrame parent;

    public CalculationListener(JTextField textField, JFrame parent) {
        this.textField = textField;
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");

        try {
            Object eval = jsEngine.eval(textField.getText());
            textField.setText(eval.toString());
        } catch (ScriptException scriptException) {
            System.out.println("Something went wrong during calculation");
        } finally {
            parent.requestFocus();
        }
    }
}
