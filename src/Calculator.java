import javax.swing.*;
import java.awt.*;

public class Calculator {
    static final double PI = 3.1416;
    static JFrame frame;
    static boolean firstTIME = true;
    static JLabel displayLabel;
    static GridBagConstraints gbc;
    static int gridx, gridy;

    public static void main(String[] args) {

        // Frame Configuration
        frame = new JFrame("CALCULATOR BY SAFI");
        frame.setSize(550, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK);

        // MenuItems
        MenuBar.createMenu();

        // Grid Bag Configuration
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;

        // Display Label
        JLabel displayLabel = DisplayLabel.createDisplayLabel("OOP Class Assignment 4 - FA23-BCS-273");
        frame.add(displayLabel, gbc);

        gbc.gridwidth = 1;
        gridx = 0;
        gridy = 1;

        // Displaying Buttons
        String[] buttons = {"7", "8", "9", "÷", "4", "5", "6", "x", "1", "2", "3", "-", "0", ".", "+", "SIN", "COS", "TAN", "π", "C", "DEL", "=",};
        for (String text : buttons) {
            JButton button = Buttons.createButton(text);
            frame.add(button, gbc);
        }

        frame.setVisible(true);
    }

}
