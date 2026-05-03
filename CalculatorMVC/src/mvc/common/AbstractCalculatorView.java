package mvc.common;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * Classe mère commune aux 3 vues.
 * RÈGLE : ne JAMAIS appeler buildCalcPanel() dans ce constructeur.
 * Chaque sous-classe appelle init() à la FIN de son constructeur,
 * après avoir initialisé tous ses champs propres.
 */
public abstract class AbstractCalculatorView extends JFrame {

    protected JPanel    calcPanel;
    protected JTextArea historyArea;
    private   JPanel    centre;

    public AbstractCalculatorView(String title, Color accentColor) {
        super(title);
        UIStyle.setDarkLookAndFeel();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 520);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(UIStyle.BG_DARK);
        setLayout(new BorderLayout(0, 0));

        // HEADER
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(UIStyle.BG_DARK);
        header.setBorder(BorderFactory.createEmptyBorder(18, 20, 6, 20));
        JLabel titleLbl = new JLabel(title);
        titleLbl.setFont(UIStyle.FONT_TITLE);
        titleLbl.setForeground(accentColor);
        header.add(titleLbl, BorderLayout.WEST);
        JLabel subLbl = new JLabel("Architecture MVC  ·  Héritage Java");
        subLbl.setFont(UIStyle.FONT_LABEL);
        subLbl.setForeground(UIStyle.TEXT_SECOND);
        header.add(subLbl, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        // CENTRE (calcPanel sera injecté par init())
        centre = new JPanel(new BorderLayout(12, 0));
        centre.setBackground(UIStyle.BG_DARK);
        centre.setBorder(BorderFactory.createEmptyBorder(0, 14, 14, 14));
        add(centre, BorderLayout.CENTER);

        // HISTORIQUE
        JPanel histPanel = new JPanel(new BorderLayout(0, 6));
        histPanel.setBackground(UIStyle.BG_PANEL);
        histPanel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(UIStyle.SEPARATOR, 1, true),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        histPanel.setPreferredSize(new Dimension(175, 0));

        JLabel histTitle = new JLabel("Historique");
        histTitle.setFont(UIStyle.FONT_LABEL);
        histTitle.setForeground(accentColor);
        histPanel.add(histTitle, BorderLayout.NORTH);

        historyArea = new JTextArea();
        historyArea.setEditable(false);
        historyArea.setBackground(UIStyle.HISTORY_BG);
        historyArea.setForeground(UIStyle.TEXT_SECOND);
        historyArea.setFont(UIStyle.FONT_HISTORY);
        historyArea.setLineWrap(true);
        historyArea.setWrapStyleWord(true);
        historyArea.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

        JScrollPane scroll = new JScrollPane(historyArea);
        scroll.setBorder(BorderFactory.createLineBorder(UIStyle.SEPARATOR, 1, true));
        scroll.getViewport().setBackground(UIStyle.HISTORY_BG);
        histPanel.add(scroll, BorderLayout.CENTER);

        JButton clrHist = UIStyle.makeButton("Effacer", UIStyle.BTN_FUNC, UIStyle.FONT_BTN_SM);
        clrHist.setPreferredSize(new Dimension(0, 30));
        clrHist.addActionListener(e -> historyArea.setText(""));
        histPanel.add(clrHist, BorderLayout.SOUTH);

        centre.add(histPanel, BorderLayout.EAST);
    }

    /**
     * Appeler en DERNIÈRE ligne du constructeur de la sous-classe.
     * Garantit que tous les champs de la sous-classe sont initialisés avant buildCalcPanel().
     */
    protected final void init() {
        calcPanel = new JPanel();
        calcPanel.setBackground(UIStyle.BG_DARK);
        buildCalcPanel();
        centre.add(calcPanel, BorderLayout.CENTER);
        centre.revalidate();
    }

    protected abstract void buildCalcPanel();

    public void addToHistory(String entry) {
        historyArea.append(entry + "\n");
        historyArea.setCaretPosition(historyArea.getDocument().getLength());
    }

    public void displayErrorMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    protected String fmt(double v) {
        if (Double.isNaN(v))      return "NaN";
        if (Double.isInfinite(v)) return v > 0 ? "+\u221e" : "-\u221e";
        if (v == Math.floor(v) && Math.abs(v) < 1e12) return String.valueOf((long) v);
        return String.format("%.8g", v);
    }
}
