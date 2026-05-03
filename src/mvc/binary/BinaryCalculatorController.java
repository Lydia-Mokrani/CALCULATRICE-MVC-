package mvc.binary;

import mvc.common.AbstractCalculatorController;

public class BinaryCalculatorController extends AbstractCalculatorController {

    private BinaryCalculatorView  view;
    private BinaryCalculatorModel model;

    public BinaryCalculatorController(BinaryCalculatorView view, BinaryCalculatorModel model) {
        super(view);
        this.view  = view;
        this.model = model;
    }

    @Override
    protected void doCalculate() {
        String a  = view.getInputA();
        String b  = view.getInputB();
        String op = view.getOperation();
        String mode = view.getInputMode();

        if (a.isEmpty() || b.isEmpty())
            throw new IllegalArgumentException("Veuillez saisir les deux opérandes");

        model.calculate(a, b, op, mode);
        String dec = model.getResultDecimal();
        String bin = model.getResultBinary();
        view.setDisplay(dec, bin);
        view.addToHistory(a + " " + op + " " + b + " [" + mode + "] = " + dec + " (bin:" + bin + ")");
    }
}
