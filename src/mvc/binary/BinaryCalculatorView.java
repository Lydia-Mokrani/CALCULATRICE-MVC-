package mvc.binary;

import mvc.common.AbstractCalculatorView;
import mvc.common.UIStyle;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class BinaryCalculatorView extends AbstractCalculatorView {

    private final JLabel     display      = new JLabel("0",  SwingConstants.RIGHT);
    private final JLabel     exprLabel    = new JLabel(" ", SwingConstants.RIGHT);
    private final JTextField fieldA       = UIStyle.makeField(10);
    private final JTextField fieldB       = UIStyle.makeField(10);
    private final JComboBox<String> opBox = new JComboBox<>(new String[]{"+","-","×","÷"});
    private final JRadioButton binBtn     = new JRadioButton("Binaire  (ex: 1010)");
    private final JRadioButton decBtn     = new JRadioButton("Décimal  (ex: 42)");

    public BinaryCalculatorView() {
        super("Calculatrice Binaire", UIStyle.BTN_BINARY);
        styleComponents();
        init(); // en dernière ligne
    }

    private void styleComponents() {
        display.setFont(new Font("SF Pro Display", Font.PLAIN, 30));
        display.setForeground(UIStyle.TEXT_PRIMARY);
        display.setBorder(BorderFactory.createEmptyBorder(0, 16, 8, 16));
        exprLabel.setFont(UIStyle.FONT_LABEL);
        exprLabel.setForeground(UIStyle.TEXT_SECOND);
        exprLabel.setBorder(BorderFactory.createEmptyBorder(0, 16, 0, 16));
        styleCombo(opBox);
        styleRadio(binBtn, UIStyle.BTN_BINARY); binBtn.setSelected(true);
        styleRadio(decBtn, UIStyle.BTN_SIMPLE);
        ButtonGroup bg = new ButtonGroup(); bg.add(binBtn); bg.add(decBtn);
    }

    @Override
    protected void buildCalcPanel() {
        calcPanel.setLayout(new BorderLayout(0, 10));

        // Display
        JPanel dp = UIStyle.roundPanel(UIStyle.BG_PANEL, 16);
        dp.setLayout(new BorderLayout());
        dp.setBorder(BorderFactory.createEmptyBorder(10, 16, 10, 16));
        dp.add(exprLabel, BorderLayout.NORTH);
        dp.add(display,   BorderLayout.CENTER);
        calcPanel.add(dp, BorderLayout.NORTH);

        // Mode BIN/DEC
        JPanel modePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 4));
        modePanel.setBackground(UIStyle.BG_DARK);
        modePanel.add(new JLabel("Mode :") {{ setForeground(UIStyle.TEXT_SECOND); setFont(UIStyle.FONT_LABEL); }});
        modePanel.add(binBtn);
        modePanel.add(decBtn);
        calcPanel.add(modePanel, BorderLayout.CENTER);

        // Formulaire
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(UIStyle.BG_DARK);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6,8,6,8);
        c.fill   = GridBagConstraints.HORIZONTAL;

        c.gridx=0; c.gridy=0; form.add(lbl("A"), c);
        c.gridx=1; c.weightx=1; form.add(fieldA, c);
        c.gridx=0; c.gridy=1; c.weightx=0; form.add(lbl("Opération"), c);
        c.gridx=1; form.add(opBox, c);
        c.gridx=0; c.gridy=2; form.add(lbl("B"), c);
        c.gridx=1; form.add(fieldB, c);

        JButton calcBtn = UIStyle.makeButton("=  Calculer", UIStyle.BTN_BINARY, UIStyle.FONT_BTN_SM);
        calcBtn.setPreferredSize(new Dimension(0, 44));
        calcBtn.addActionListener(e -> { if (calcListener != null) calcListener.actionPerformed(e); });
        c.gridx=0; c.gridy=3; c.gridwidth=2; c.insets=new Insets(12,8,6,8);
        form.add(calcBtn, c);
        calcPanel.add(form, BorderLayout.SOUTH);
    }

    public String getInputA()    { return fieldA.getText().trim(); }
    public String getInputB()    { return fieldB.getText().trim(); }
    public String getOperation() { return (String) opBox.getSelectedItem(); }
    public String getInputMode() { return binBtn.isSelected() ? "BIN" : "DEC"; }
    public void setDisplay(String dec, String bin) {
        display.setText(dec); exprLabel.setText("Binaire : " + bin);
    }
}
