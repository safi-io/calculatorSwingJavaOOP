import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class History {
    public History() {
        JFrame frame = new JFrame();
        frame.setTitle("History");
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label123 = new JLabel("RECENT CALCULATIONS.");
        label123.setForeground(Color.white);
        label123.setFont(new Font("", Font.BOLD, 28));
        label123.setBorder(BorderFactory.createEmptyBorder(10,10,20,0));
        panel.add(label123);

        panel.setBackground(Color.BLACK);

        ArrayList<String> expressionsArray = FileHandling.readFile();

        for (int i = expressionsArray.size() - 1; i >= 0; i--) {
            JLabel label = new JLabel(expressionsArray.get(i));
            label.setFont(new Font("", Font.PLAIN, 16));
            label.setForeground(Color.WHITE);
            label.setOpaque(true);
            label.setBackground(new Color(50, 50, 50));
            label.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(label);
            panel.add(Box.createRigidArea(new Dimension(5, 5)));
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(100, 100, 100);
                this.trackColor = Color.BLACK; // Black track
            }
        });

        scrollPane.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        frame.add(scrollPane);

        frame.setVisible(true);
    }

}
