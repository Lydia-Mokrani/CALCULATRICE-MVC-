package mvc.common;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class UIStyle {
    // iOS Dark palette
    public static final Color BG_DARK       = new Color(0x1C1C1E);
    public static final Color BG_PANEL      = new Color(0x2C2C2E);
    public static final Color BG_FIELD      = new Color(0x3A3A3C);
    public static final Color BTN_DARK      = new Color(0x3A3A3C);
    public static final Color BTN_OP        = new Color(0xFF9F0A);
    public static final Color BTN_FUNC      = new Color(0x636366);
    public static final Color BTN_EQUALS    = new Color(0xFF9F0A);
    public static final Color BTN_CLEAR     = new Color(0xFF453A);
    public static final Color BTN_SIMPLE    = new Color(0x0A84FF);
    public static final Color BTN_BINARY    = new Color(0x30D158);
    public static final Color BTN_SCIENCE   = new Color(0xBF5AF2);
    public static final Color TEXT_PRIMARY  = new Color(0xFFFFFF);
    public static final Color TEXT_SECOND   = new Color(0xAEAEB2);
    public static final Color TEXT_ORANGE   = new Color(0xFF9F0A);
    public static final Color HISTORY_BG    = new Color(0x1C1C1E);
    public static final Color SEPARATOR     = new Color(0x48484A);

    public static final Font FONT_DISPLAY   = new Font("SF Pro Display", Font.PLAIN, 36);
    public static final Font FONT_BTN_LG    = new Font("SF Pro Display", Font.PLAIN, 22);
    public static final Font FONT_BTN_SM    = new Font("SF Pro Display", Font.PLAIN, 16);
    public static final Font FONT_LABEL     = new Font("SF Pro Text",    Font.PLAIN, 13);
    public static final Font FONT_TITLE     = new Font("SF Pro Display", Font.BOLD,  18);
    public static final Font FONT_HISTORY   = new Font("SF Pro Text",    Font.PLAIN, 12);

    /** Bouton iOS arrondi */
    public static JButton makeButton(String text, Color bg, Font font) {
        JButton btn = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setFont(font);
        btn.setBackground(bg);
        btn.setForeground(TEXT_PRIMARY);
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            Color orig = bg;
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(bg.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(orig);
            }
            public void mousePressed(java.awt.event.MouseEvent e) {
                btn.setBackground(bg.darker());
            }
            public void mouseReleased(java.awt.event.MouseEvent e) {
                btn.setBackground(orig);
            }
        });
        return btn;
    }

    /** Champ de texte iOS */
    public static JTextField makeField(int cols) {
        JTextField f = new JTextField(cols) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        f.setBackground(BG_FIELD);
        f.setForeground(TEXT_PRIMARY);
        f.setCaretColor(TEXT_ORANGE);
        f.setFont(new Font("SF Pro Display", Font.PLAIN, 20));
        f.setBorder(BorderFactory.createEmptyBorder(8, 14, 8, 14));
        f.setOpaque(false);
        f.setHorizontalAlignment(JTextField.RIGHT);
        return f;
    }

    /** Label résultat style iOS (grand, à droite) */
    public static JLabel makeResultLabel() {
        JLabel l = new JLabel("0", SwingConstants.RIGHT);
        l.setFont(new Font("SF Pro Display", Font.PLAIN, 48));
        l.setForeground(TEXT_PRIMARY);
        l.setBorder(BorderFactory.createEmptyBorder(0, 16, 8, 16));
        return l;
    }

    /** Panel avec fond arrondi */
    public static JPanel roundPanel(Color bg, int radius) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(bg);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
                g2.dispose();
            }
        };
    }

    public static void setDarkLookAndFeel() {
        UIManager.put("OptionPane.background",        BG_PANEL);
        UIManager.put("Panel.background",             BG_PANEL);
        UIManager.put("OptionPane.messageForeground", TEXT_PRIMARY);
        UIManager.put("Button.background",            BTN_DARK);
        UIManager.put("Button.foreground",            TEXT_PRIMARY);
    }
}
