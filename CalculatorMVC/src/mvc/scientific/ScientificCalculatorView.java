package mvc.scientific;

import mvc.common.AbstractCalculatorView;
import mvc.common.UIStyle;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ScientificCalculatorView extends AbstractCalculatorView {

    private final JLabel     display   = new JLabel("0", SwingConstants.RIGHT);
    private final JLabel     exprLbl   = new JLabel(" ", SwingConstants.RIGHT);
    private final JTextField fieldA    = UIStyle.makeField(10);
    private final JTextField fieldB    = UIStyle.makeField(10);
    private final JComboBox<String> binOpBox = new JComboBox<>(ScientificCalculatorModel.BINARY_OPS);
    private final JComboBox<String> uniOpBox = new JComboBox<>(ScientificCalculatorModel.UNARY_OPS);
    private final JRadioButton binRadio = new JRadioButton("Binaire  (+  –  ×  ÷  pow)");
    private final JRadioButton uniRadio = new JRadioButton("Unaire   (sin  cos  √  …)");
    private JLabel labelB;
    private ActionListener calcListener;

    public ScientificCalculatorView() {
        super("Calculatrice Scientifique", UIStyle.BTN_SCIENCE);
        styleComponents();
        init(); // en dernière ligne
    }

    private void styleComponents() {
        display.setFont(new Font("SF Pro Display", Font.PLAIN, 30));
        display.setForeground(UIStyle.TEXT_PRIMARY);
        display.setBorder(BorderFactory.createEmptyBorder(0, 16, 8, 16));
        exprLbl.setFont(UIStyle.FONT_LABEL);
        exprLbl.setForeground(UIStyle.TEXT_SECOND);
        exprLbl.setBorder(BorderFactory.createEmptyBorder(0, 16, 0, 16));
        styleCombo(binOpBox); styleCombo(uniOpBox);
        styleRadio(binRadio, UIStyle.BTN_OP);     binRadio.setSelected(true);
        styleRadio(uniRadio, UIStyle.BTN_SCIENCE);
        ButtonGroup bg = new ButtonGroup(); bg.add(binRadio); bg.add(uniRadio);
        binRadio.addActionListener(e -> updateMode());
        uniRadio.addActionListener(e -> updateMode());
    }

    @Override
    protected void buildCalcPanel() {
        calcPanel.setLayout(new BorderLayout(0, 8));

        // Display
        JPanel dp = UIStyle.roundPanel(UIStyle.BG_PANEL, 16);
        dp.setLayout(new BorderLayout());
        dp.setBorder(BorderFactory.createEmptyBorder(10, 16, 10, 16));
        dp.add(exprLbl, BorderLayout.NORTH);
        dp.add(display, BorderLayout.CENTER);
        calcPanel.add(dp, BorderLayout.NORTH);

        // Type opération
        JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 24, 4));
        typePanel.setBackground(UIStyle.BG_DARK);
        typePanel.add(binRadio); typePanel.add(uniRadio);
        calcPanel.add(typePanel, BorderLayout.CENTER);

        // Formulaire
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(UIStyle.BG_DARK);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,8,5,8); c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx=0; c.gridy=0; form.add(lbl("A"), c);
        c.gridx=1; c.weightx=1; form.add(fieldA, c);
        c.gridx=0; c.gridy=1; c.weightx=0; form.add(lbl("Opération"), c);
        c.gridx=1; form.add(binOpBox, c);
        c.gridx=1; form.add(uniOpBox, c);  // superposé, un seul visible
        labelB = lbl("B");
        c.gridx=0; c.gridy=2; form.add(labelB, c);
        c.gridx=1; form.add(fieldB, c);

        JButton calcBtn = UIStyle.makeButton("=  Calculer", UIStyle.BTN_SCIENCE, UIStyle.FONT_BTN_SM);
        calcBtn.setPreferredSize(new Dimension(0, 44));
        calcBtn.addActionListener(e -> { if (calcListener != null) calcListener.actionPerformed(e); });
        c.gridx=0; c.gridy=3; c.gridwidth=2; c.insets=new Insets(12,8,6,8);
        form.add(calcBtn, c);
        calcPanel.add(form, BorderLayout.SOUTH);

        uniOpBox.setVisible(false); // binaire par défaut
    }

    private void updateMode() {
        boolean bin = binRadio.isSelected();
        binOpBox.setVisible(bin); uniOpBox.setVisible(!bin);
        labelB.setVisible(bin);   fieldB.setVisible(bin);
        calcPanel.revalidate(); calcPanel.repaint();
    }

    private JLabel lbl(String t) {
        JLabel l = new JLabel(t); l.setForeground(UIStyle.TEXT_SECOND); l.setFont(UIStyle.FONT_LABEL); return l;
    }
    private void styleCombo(JComboBox<String> cb) {
        cb.setBackground(UIStyle.BG_FIELD); cb.setForeground(UIStyle.TEXT_PRIMARY);
        cb.setFont(UIStyle.FONT_BTN_SM); cb.setBorder(BorderFactory.createLineBorder(UIStyle.SEPARATOR,1,true));
    }
    private void styleRadio(JRadioButton r, Color c) {
        r.setBackground(UIStyle.BG_DARK); r.setForeground(c); r.setFont(UIStyle.FONT_LABEL); r.setFocusPainted(false);
    }

    public boolean isBinaryMode() { return binRadio.isSelected(); }
    public double  getA()         { return Double.parseDouble(fieldA.getText().trim()); }
    public double  getB()         { return Double.parseDouble(fieldB.getText().trim()); }
    public String  getBinaryOp()  { return (String) binOpBox.getSelectedItem(); }
    public String  getUnaryOp()   { return (String) uniOpBox.getSelectedItem(); }
    public void setDisplay(String expr, String result) { exprLbl.setText(expr); display.setText(result); }
    public void addCalculateListener(ActionListener l) { calcListener = l; }
}
