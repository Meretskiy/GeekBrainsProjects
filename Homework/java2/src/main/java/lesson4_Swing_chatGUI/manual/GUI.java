package lesson4_Swing_chatGUI.manual;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {

    public GUI() {
        //set option frame
        setBounds(500, 200, 800, 600);
        setTitle("GUI Demo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));
        //add panel
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        JPanel jPanel4 = new JPanel();
        //add color panel
        jPanel1.setBackground(new Color(100, 100, 100));
        jPanel2.setBackground(new Color(150, 250, 150));
        jPanel3.setBackground(new Color(100, 200, 200));
        jPanel4.setBackground(new Color(10, 100, 100));
        //add panel in frame
        add(jPanel1);
        add(jPanel2);
        add(jPanel3);
        add(jPanel4);
        //sets up panel1, add text area in scroll pane, and add scroll pane in panel1
        jPanel1.setLayout(new BorderLayout());
        JTextArea jTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jPanel1.add(jScrollPane);
        //sets up panel2 and add button group
        jPanel2.setLayout(new FlowLayout());
        ButtonGroup buttonGroup = new ButtonGroup();
        //add radiobutton1 in button group and in panel2
        JRadioButton jRadioButton1 = new JRadioButton("Option 1");
        buttonGroup.add(jRadioButton1);
        jPanel2.add(jRadioButton1);
        //add radiobutton2 in button group and in panel2
        JRadioButton jRadioButton2 = new JRadioButton("Option 2");
        buttonGroup.add(jRadioButton2);
        jPanel2.add(jRadioButton2);
        //add radiobutton3 in button group and in panel2
        JRadioButton jRadioButton3 = new JRadioButton("Option 3");
        buttonGroup.add(jRadioButton3);
        jPanel2.add(jRadioButton3);
        //add radiobutton4 in button group and in panel2
        JRadioButton jRadioButton4 = new JRadioButton("Option 4");
        buttonGroup.add(jRadioButton4);
        jPanel2.add(jRadioButton4);
        //add checkbox in panel2
        JCheckBox jCheckBox1 = new JCheckBox("Check 1");
        JCheckBox jCheckBox2 = new JCheckBox("Check 2");
        JCheckBox jCheckBox3 = new JCheckBox("Check 3");
        JCheckBox jCheckBox4 = new JCheckBox("Check 4");
        jPanel2.add(jCheckBox1);
        jPanel2.add(jCheckBox2);
        jPanel2.add(jCheckBox3);
        jPanel2.add(jCheckBox4);
        //add button in panel2
        JButton button = new JButton("Button");
        jPanel2.add(button);
        //add action listener pressed button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button pressed...");
            }
        });
        //sets up panel3
        jPanel3.setLayout(new FlowLayout());
        //add array combo box item
        String[] comboStr = {"Item #1", "Item #2", "Item #3", "Item #4"};
        //add array in combo box and add in panel3
        JComboBox<String> jComboBox1 = new JComboBox<>(comboStr);
        JComboBox<String> jComboBox2 = new JComboBox<>(comboStr);
        JComboBox<String> jComboBox3 = new JComboBox<>(comboStr);
        jPanel3.add(jComboBox1);
        jPanel3.add(jComboBox2);
        jPanel3.add(jComboBox3);
        //Action Listener combo box 1
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jComboBox1.getSelectedItem().toString());
            }
        });
        //add text field in panel3
        JTextField field = new JTextField();
        jPanel3.add(field);
        //add Action listener for Enter in text area
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You message: " + field.getText());
            }
        });
        //off set up panel4
        jPanel4.setLayout(null);
        //add slider and label
        JSlider jSlider = new JSlider();
        JLabel jLabel = new JLabel("Value 50");
        //sets up and add slider
        jSlider.setMaximum(100);
        jSlider.setMinimum(0);
        jSlider.setValue(50);
        jPanel4.add(jSlider);
        jPanel4.add(jLabel);
        //add Change Listener
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jLabel.setText("Value" + jSlider.getValue());
            }
        });
        // sets up bounds label and slider in panel4
        jLabel.setBounds(10, 10, 100, 20);
        jSlider.setBounds(20, 40, 300, 100);
        jSlider.setBackground(new Color(100, 50, 200)); //fusk!!!
        //add menu bar
        JMenuBar mainMenu = new JMenuBar();
        //add menu
        JMenu mFile = new JMenu("File");
        JMenu mEdit = new JMenu("Edit");
        //add menu item
        JMenuItem miFileNew = new JMenuItem("New");
        JMenuItem miFileExit = new JMenuItem("Exit");
        //set menu bar
        setJMenuBar(mainMenu);
        //add menu in menu bar
        mainMenu.add(mFile);
        mainMenu.add(mEdit);
        //add menu item in menu
        mFile.add(miFileNew);
        //add line in menu
        mFile.addSeparator();
        //add menu item in menu
        mFile.add(miFileExit);
        //add listener menu item
        miFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //add listener closing app
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("BYE");
            }
        });
        //add listener mouse position click
        jPanel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse pos: " + e.getX() + " " + e.getY());
            }
        });

        setVisible(true);
    }
}
