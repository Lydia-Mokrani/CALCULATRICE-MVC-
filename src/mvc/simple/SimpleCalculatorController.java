package mvc.simple;

import mvc.common.AbstractCalculatorController;

public class SimpleCalculatorController extends AbstractCalculatorController {

    private SimpleCalculatorView  view;
    private SimpleCalculatorModel model;

    public SimpleCalculatorController(SimpleCalculatorView view, SimpleCalculatorModel model) {
        super(view);
        this.view  = view;
        this.model = model;
    }

    @Override
    protected void doCalculate() {
        double a  = view.getFirstNumber();
        double b  = view.getSecondNumber();
        String op = view.getOperation();
        model.calculate(a, b, op);
        double result = model.getResult();
        view.setResult(result);
        view.addToHistory(model.format(a) + " " + op + " " + model.format(b) + " = " + model.format(result));
    }
}
