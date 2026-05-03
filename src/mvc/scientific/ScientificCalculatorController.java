package mvc.scientific;

import mvc.common.AbstractCalculatorController;

public class ScientificCalculatorController extends AbstractCalculatorController {

    private ScientificCalculatorView  view;
    private ScientificCalculatorModel model;

    public ScientificCalculatorController(ScientificCalculatorView view, ScientificCalculatorModel model) {
        super(view);
        this.view  = view;
        this.model = model;
    }

    @Override
    protected void doCalculate() {
        if (view.isBinaryMode()) {
            double a  = view.getA();
            double b  = view.getB();
            String op = view.getBinaryOp();
            model.calculateBinary(a, b, op);
            String res = model.format(model.getResult());
            view.setDisplay(model.format(a) + " " + op + " " + model.format(b) + " =", res);
            view.addToHistory(model.format(a) + " " + op + " " + model.format(b) + " = " + res);
        } else {
            double a  = view.getA();
            String op = view.getUnaryOp();
            model.calculateUnary(a, op);
            String res = model.format(model.getResult());
            view.setDisplay(op + "(" + model.format(a) + ") =", res);
            view.addToHistory(op + "(" + model.format(a) + ") = " + res);
        }
    }
}
