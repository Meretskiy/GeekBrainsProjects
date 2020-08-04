package lesson4.lesson;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ButtonKeyListener implements KeyListener {
    private final JTextField textField;

    public ButtonKeyListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        /**
         * Выполняем действие в соответствии с символом, который нажат на клавиатуре
         */
        switch (e.getKeyChar()) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '-':
            case '+':
            case '/':
            case '*': {
                StringBuilder sb = new StringBuilder(textField.getText());
                sb.append(e.getKeyChar());
                textField.setText(sb.toString());
                break;
            }
            case KeyEvent.VK_BACK_SPACE: {
                StringBuilder sb = new StringBuilder(textField.getText());
                sb.setLength(sb.length() - 1);
                textField.setText(sb.toString());
                break;
            }
            case '=':
            case KeyEvent.VK_ENTER: {
                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");

                try {
                    Object eval = jsEngine.eval(textField.getText());
                    textField.setText(eval.toString());
                } catch (ScriptException scriptException) {
                    System.out.println("Something went wrong during calculation");
                }
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
