import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons {
    public static JButton createButton(String text) {
        JButton button = new JButton(text);
        Calculator.displayLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE), BorderFactory.createEmptyBorder(0, 0, 0, 10)));

        // Designing Button
        button.setMaximumSize(new Dimension(300, 60));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFocusable(false);
        button.setBackground(new Color(28, 50, 91));
        button.setForeground(Color.white);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE), BorderFactory.createEmptyBorder(10, 20, 10, 10)));
        button.setFont(new Font("", Font.HANGING_BASELINE, 26));

        if (text.equals("+") || text.equals("-") || text.equals("x") || text.equals("÷") || text.equals("=")) {
            button.setFont(new Font("", Font.BOLD, 24));
            button.setBackground(new Color(70, 80, 61));
        }

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(106, 102, 156));
                button.setForeground(Color.WHITE);

                if (text.equals("+") || text.equals("-") || text.equals("x") || text.equals("÷") || text.equals("=")) {
                    button.setBackground(new Color(96, 70, 61));
                }

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(28, 50, 91));
                button.setForeground(Color.WHITE);

                if (text.equals("+") || text.equals("-") || text.equals("x") || text.equals("÷") || text.equals("=")) {
                    button.setBackground(new Color(70, 80, 61));
                }
            }
        });

        Calculator.gbc.gridx = Calculator.gridx;
        Calculator.gbc.gridy = Calculator.gridy;

        if (text.equals("0") || text.equals("=")) {
            Calculator.gbc.gridwidth = 2;
            Calculator.gridx += 2;
        } else {
            Calculator.gbc.gridwidth = 1;
            Calculator.gridx++;
        }

        if (Calculator.gridx == 4) {
            Calculator.gridx = 0;
            Calculator.gridy++;
        }

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (Calculator.firstTIME) {
                    Calculator.displayLabel.setText("");
                    Calculator.displayLabel.setHorizontalAlignment(JLabel.RIGHT);
                    Calculator.firstTIME = false;
                }

                String currentText = Calculator.displayLabel.getText();

                if (text.equals("C")) {
                    Calculator.displayLabel.setText(" ");
                } else if (text.equals("=")) {
                    try {

                        String replacedString = currentText.replace('x', '*').replace('÷', '/');

                        Expression expr = new ExpressionBuilder(replacedString.toLowerCase()).build();
                        double result = expr.evaluate();
                        Calculator.displayLabel.setText(String.valueOf(result));

                        String expressionToStore = currentText + " = " + result;
                        FileHandling.writeFile(expressionToStore);

                    } catch (RuntimeException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (text.equals("DEL")) {
                    int length = currentText.length();
                    if (length == 0) return;
                    Calculator.displayLabel.setText(currentText.substring(0, length - 1));
                } else if (text.equals("π")) {
                    Calculator.displayLabel.setText(currentText + Calculator.PI);
                } else {
                    Calculator.displayLabel.setText(currentText + text);
                }
            }

        });

        return button;
    }
}
