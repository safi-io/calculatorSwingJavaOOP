import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar {
    public static void createMenu() {
        JMenu menu = new JMenu("HISTORY");
        menu.setForeground(Color.WHITE);
        JMenuItem viewHistory = new JMenuItem("VIEW HISTORY");
        JMenuItem deleteHistory = new JMenuItem("DELETE HISTORY");
        menu.add(viewHistory);
        menu.add(deleteHistory);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.BLACK);
        menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray)); // No bottom border


        menuBar.add(menu);

        // Add ActionListeners to menu items
        viewHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new History();
            }
        });

        deleteHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action for DELETE HISTORY
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete history?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    FileHandling.deleteFile();
                    JOptionPane.showMessageDialog(null, "History Deleted", "HISTORY", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        Calculator.frame.setJMenuBar(menuBar);
    }
}
