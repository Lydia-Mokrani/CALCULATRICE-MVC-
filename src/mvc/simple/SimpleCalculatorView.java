package mvc.simple;

import mvc.common.AbstractCalculatorView;
import mvc.common.UIStyle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculatorView extends AbstractCalculatorView {

    // Tous les champs initialisés ICI, avant init()
    private final JLabel  displayLabel    = new JLabel("0", SwingConstants.RIGHT);
    private final JLabel  expressionLabel = new JLabel(" ", SwingConstants.RIGHT);

    private double  pendingValue = 0;
    private String  pendingOp    = "";
    private boolean resetNext    = false;
    private String  currentInput = "0";

    private double firstNum, secondNum;
    private String operation;

    public SimpleCalculatorView() {
        super("Calculatrice Simple", UIStyle.BTN_SIMPLE);
        // Styler les labels AVANT init()
        displayLabel.setFont(new Font("SF Pro Display", Font.PLAIN, 46));
        displayLabel.setForeground(UIStyle.TEXT_PRIMARY);
        displayLabel.setBorder(BorderFactory.createEmptyBorder(0, 16, 8, 16));
        expressionLabel.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
        expressionLabel.setForeground(UIStyle.TEXT_SECOND);
        expressionLabel.setBorder(BorderFactory.createEmptyBorder(0, 16, 0, 16));
        init(); // TOUJOURS en dernière ligne
    }

    @Override
    protected void buildCalcPanel() {
        calcPanel.setLayout(new BorderLayout(0, 8));

        // Display
        JPanel dp = new JPanel(new BorderLayout());
        dp.setBackground(UIStyle.BG_DARK);
        dp.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        dp.add(expressionLabel, BorderLayout.NORTH);
        dp.add(displayLabel,    BorderLayout.CENTER);
        calcPanel.add(dp, BorderLayout.NORTH);

        // Grille iOS 5x4
        JPanel grid = new JPanel(new GridLayout(5, 4, 10, 10));
        grid.setBackground(UIStyle.BG_DARK);
        grid.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

        // Ligne 1
        btn(grid, "AC",  UIStyle.BTN_FUNC, e -> clearAll());
        btn(grid, "+/-", UIStyle.BTN_FUNC, e -> negate());
        btn(grid, "%",   UIStyle.BTN_FUNC, e -> percent());
        btn(grid, "÷",   UIStyle.BTN_OP,   e -> opPressed("÷"));
        // Ligne 2
        digit(grid,"7"); digit(grid,"8"); digit(grid,"9");
        btn(grid, "×", UIStyle.BTN_OP, e -> opPressed("×"));
        // Ligne 3
        digit(grid,"4"); digit(grid,"5"); digit(grid,"6");
        btn(grid, "-", UIStyle.BTN_OP, e -> opPressed("-"));
        // Ligne 4
        digit(grid,"1"); digit(grid,"2"); digit(grid,"3");
        btn(grid, "+", UIStyle.BTN_OP, e -> opPressed("+"));
        // Ligne 5
        digit(grid,"0");
        btn(grid, "⌫", UIStyle.BTN_FUNC, e -> backspace());
        btn(grid, ".", UIStyle.BTN_DARK,  e -> dotPressed());
        btn(grid, "=", UIStyle.BTN_OP,    e -> equalsPressed());

        calcPanel.add(grid, BorderLayout.CENTER);
    }

    private void btn(JPanel p, String t, Color bg, ActionListener al) {
        JButton b = UIStyle.makeButton(t, bg, UIStyle.FONT_BTN_LG);
        b.setPreferredSize(new Dimension(0, 58));
        b.addActionListener(al);
        p.add(b);
    }
    private void digit(JPanel p, String d) {
        btn(p, d, UIStyle.BTN_DARK, e -> digitPressed(d));
    }

    // Logique clavier
    private void digitPressed(String d) {
        if (resetNext) { currentInput = "0".equals(d) ? "0" : d; resetNext = false; }
        else currentInput = "0".equals(currentInput) ? d : currentInput + d;
        displayLabel.setText(currentInput);
    }
    private void dotPressed() {
        if (resetNext) { currentInput = "0."; resetNext = false; }
        else if (!currentInput.contains(".")) currentInput += ".";
        displayLabel.setText(currentInput);
    }
    private void backspace() {
        if (currentInput.length() > 1) currentInput = currentInput.substring(0, currentInput.length()-1);
        else currentInput = "0";
        displayLabel.setText(currentInput);
    }
    private void clearAll() {
        currentInput = "0"; pendingValue = 0; pendingOp = ""; resetNext = false;
        expressionLabel.setText(" "); displayLabel.setText("0");
    }
    private void negate() {
        double v = -Double.parseDouble(currentInput);
        currentInput = fmt(v); displayLabel.setText(currentInput);
    }
    private void percent() {
        double v = Double.parseDouble(currentInput) / 100.0;
        currentInput = fmt(v); displayLabel.setText(currentInput);
    }
    private void opPressed(String op) {
        pendingValue = Double.parseDouble(currentInput);
        pendingOp = op;
        expressionLabel.setText(fmt(pendingValue) + " " + op);
        resetNext = true;
    }
    private void equalsPressed() {
        if (pendingOp.isEmpty()) return;
        firstNum  = pendingValue;
        secondNum = Double.parseDouble(currentInput);
        operation = pendingOp;
        expressionLabel.setText(fmt(firstNum) + " " + operation + " " + fmt(secondNum) + " =");
        if (calcListener != null) calcListener.actionPerformed(null);
        pendingOp = ""; resetNext = true;
    }

    // API pour le contrôleur
    public void setResult(double v) {
        currentInput = fmt(v); displayLabel.setText(currentInput);
    }
    public double getFirstNumber()  { return firstNum; }
    public double getSecondNumber() { return secondNum; }
    public String getOperation()    { return operation; }
}
