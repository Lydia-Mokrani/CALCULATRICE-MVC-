package mvc.scientific;

import mvc.common.AbstractCalculatorController;

public class ScientificCalculatorController extends AbstractCalculatorController {

    private ScientificCalculatorView  view;
    private ScientificCalculatorModel model;

    public ScientificCalculatorController(ScientificCalculatorView view, ScientificCalculatorModel model) {
        super(view);
        this.view  = view;
        this.model = model;
        view.addCalculateListener(e -> doCalculate());
    }

    @Override
    protected void doCalculate() {
        try {
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
        } catch (ArithmeticException ex) {
            view.displayErrorMessage(ex.getMessage());
        } catch (NumberFormatException ex) {
            view.displayErrorMessage("Entrée invalide — utilisez des nombres (ex: 3.14)");
        } catch (Exception ex) {
            view.displayErrorMessage(ex.getMessage());
        }
    }
}
