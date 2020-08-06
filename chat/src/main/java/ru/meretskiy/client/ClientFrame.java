package ru.meretskiy.client;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ClientFrame extends JFrame {

    private DataInputStream in;
    private DataOutputStream out;
    private boolean isAuth = false;
    String name = "";
    JTextArea textArea = new JTextArea();

    public ClientFrame(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;

        startGUI();
        readMsg();
    }

    private void readMsg() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String serverStr = in.readUTF();
                        if (serverStr.startsWith("/authok ")) {
                            String[] parts = serverStr.split("\\s");
                            name = parts[1];
                            setAuthorized(true);
                            break;
                        }
                        textArea.append(serverStr + "\n");
                    }

                    File chatHistory = new File(name + "_chat_history.txt");
                    readHistory(chatHistory);

                    while (true) {
                        String serverStr = in.readUTF();

                        if (serverStr.startsWith("/end")) {
                            break;
                        }
                        if (serverStr.startsWith("/changeOk ")) {
                            String[] part = serverStr.split("\\s");
                            File newFile = new File(part[1] + "_chat_history.txt");
                            if (chatHistory.renameTo(newFile)) {
                                name = part[1];
                                chatHistory = newFile;
                                continue;
                            } else {
                                break;
                            }
                        }
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(chatHistory, true))) {
                            writer.write(serverStr + "\n");
                        }
                        textArea.append(serverStr);
                        textArea.append("\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    private void setAuthorized(boolean b) {
        isAuth = b;
    }

    private void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readHistory(File chatHistory) {
        StringBuilder stringBuilder = new StringBuilder();
        try (RandomAccessFile raf = new RandomAccessFile(chatHistory, "r")) {
            long seek = raf.length() - 1;
            int number = 0;
            while (seek >= 0) {
                raf.seek(seek);
                char symbol = (char) raf.read();
                if (symbol == '\n') {
                    number++;
                    if (number > 100) {
                        break;
                    }
                }
                stringBuilder.append(symbol);
                seek -= 1;
            }
            stringBuilder.reverse();
            textArea.setText(stringBuilder.toString());
            stringBuilder = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startGUI() {

        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(700, 300, 500, 500);
        setLayout(new BorderLayout());

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        add(textPanel, BorderLayout.CENTER);

        JPanel enterPanel = new JPanel();
        enterPanel.setBackground(new Color(5, 175, 5));
        enterPanel.setLayout(new BorderLayout());
        add(enterPanel, BorderLayout.SOUTH);

        textArea = new JTextArea();
        textArea.setEnabled(false);
        textPanel.add(textArea, BorderLayout.CENTER);
        JScrollPane ScrollPane = new JScrollPane(textArea);
        textPanel.add(ScrollPane);

        JTextField textField = new JTextField();
        enterPanel.add(textField, BorderLayout.CENTER);
        textField.addActionListener(new TextListener(textField, out));

        JButton button = new JButton("Enter");
        enterPanel.add(button, BorderLayout.EAST);
        button.addActionListener(new TextListener(textField, out));

        setVisible(true);
    }
}