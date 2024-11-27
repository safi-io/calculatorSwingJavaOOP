import javax.swing.*;
import java.awt.*;

public class DisplayLabel {
    public static JLabel createDisplayLabel(String text) {
        Calculator.displayLabel = new JLabel();
        Calculator.displayLabel.setFont(new Font("", Font.HANGING_BASELINE, 22));
        Calculator.displayLabel.setForeground(Color.white);
        Calculator.displayLabel.setBackground(new Color(34, 103, 122));
        Calculator.displayLabel.setHorizontalAlignment(JLabel.CENTER);
        Calculator.displayLabel.setBorder(BorderFactory.createLineBorder(Color.white));
        Calculator.displayLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        Calculator.displayLabel.setOpaque(true);
        Calculator.displayLabel.setText(text);
        return Calculator.displayLabel;
    }
}
