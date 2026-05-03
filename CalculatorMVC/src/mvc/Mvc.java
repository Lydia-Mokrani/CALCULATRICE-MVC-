package mvc;

import mvc.menu.MainMenu;
import javax.swing.SwingUtilities;

public class Mvc {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu menu = new MainMenu();
            menu.setVisible(true);
        });
    }
}
