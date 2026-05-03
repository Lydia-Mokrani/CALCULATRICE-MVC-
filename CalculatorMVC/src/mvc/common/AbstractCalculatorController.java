package mvc.common;

import java.awt.event.ActionListener;

public abstract class AbstractCalculatorController {

    protected AbstractCalculatorView theView;

    public AbstractCalculatorController(AbstractCalculatorView view) {
        this.theView = view;
    }

    /** La sous-classe effectue le calcul et renvoie la ligne d'historique */
    protected abstract void doCalculate();
}
