package mvc.menu;

import mvc.common.UIStyle;
import mvc.simple.*;
import mvc.binary.*;
import mvc.scientific.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        super("Calculatrice MVC");
        UIStyle.setDarkLookAndFeel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 380);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(UIStyle.BG_DARK);
        setLayout(new BorderLayout());

        // ── Header ───────────────────────────────────────────────────────
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(UIStyle.BG_DARK);
        header.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        JLabel icon = new JLabel("⌗", SwingConstants.CENTER);
        icon.setFont(new Font("Serif", Font.PLAIN, 40));
        icon.setForeground(UIStyle.BTN_OP);
        header.add(icon, BorderLayout.NORTH);

        JLabel title = new JLabel("Calculatrice MVC", SwingConstants.CENTER);
        title.setFont(new Font("SF Pro Display", Font.BOLD, 22));
        title.setForeground(UIStyle.TEXT_PRIMARY);
        header.add(title, BorderLayout.CENTER);

        JLabel sub = new JLabel("Choisissez une calculatrice", SwingConstants.CENTER);
        sub.setFont(UIStyle.FONT_LABEL);
        sub.setForeground(UIStyle.TEXT_SECOND);
        header.add(sub, BorderLayout.SOUTH);

        add(header, BorderLayout.NORTH);

        // ── Boutons ──────────────────────────────────────────────────────
        JPanel btnPanel = new JPanel(new GridLayout(3, 1, 0, 14));
        btnPanel.setBackground(UIStyle.BG_DARK);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 30, 40));

        btnPanel.add(makeMenuBtn("  Simple   ·  + – × ÷",         UIStyle.BTN_SIMPLE,  e -> openCalculator(SimpleCalculatorModel::new, SimpleCalculatorView::new, SimpleCalculatorController::new)));
        btnPanel.add(makeMenuBtn("  Binaire  ·  BIN / DEC",        UIStyle.BTN_BINARY,  e -> openCalculator(BinaryCalculatorModel::new, BinaryCalculatorView::new, BinaryCalculatorController::new)));
        btnPanel.add(makeMenuBtn("  Scientifique  ·  sin cos √…",  UIStyle.BTN_SCIENCE, e -> openCalculator(ScientificCalculatorModel::new, ScientificCalculatorView::new, ScientificCalculatorController::new)));

        add(btnPanel, BorderLayout.CENTER);

        // ── Footer ───────────────────────────────────────────────────────
        JLabel footer = new JLabel("MVC Architecture · Java Swing", SwingConstants.CENTER);
        footer.setFont(new Font("SF Pro Text", Font.PLAIN, 11));
        footer.setForeground(UIStyle.SEPARATOR);
        footer.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));
        add(footer, BorderLayout.SOUTH);
    }

    private JButton makeMenuBtn(String text, Color color, java.awt.event.ActionListener al) {
        JButton b = UIStyle.makeButton(text, color, UIStyle.FONT_BTN_SM);
        b.setPreferredSize(new Dimension(0, 52));
        b.setHorizontalAlignment(SwingConstants.CENTER);
        b.addActionListener(al);
        return b;
    }

    private <M extends mvc.common.ICalculatorModel, V extends mvc.common.AbstractCalculatorView, C extends mvc.common.AbstractCalculatorController> void openCalculator(
            java.util.function.Supplier<M> modelFactory,
            java.util.function.Supplier<V> viewFactory,
            java.util.function.BiFunction<V, M, C> controllerFactory) {
        M m = modelFactory.get();
        V v = viewFactory.get();
        controllerFactory.apply(v, m);
        v.setVisible(true);
    }
}
