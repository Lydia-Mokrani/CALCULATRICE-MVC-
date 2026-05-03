package mvc.common;

import java.awt.event.ActionListener;

public abstract class AbstractCalculatorController {

    protected AbstractCalculatorView theView;

    public AbstractCalculatorController(AbstractCalculatorView view) {
        this.theView = view;
        this.theView.addCalculateListener(e -> {
            try {
                doCalculate();
            } catch (ArithmeticException ex) {
                theView.displayErrorMessage(ex.getMessage());
            } catch (NumberFormatException ex) {
                theView.displayErrorMessage("Entrée invalide — utilisez des nombres (ex: 3.14)");
            } catch (Exception ex) {
                theView.displayErrorMessage(ex.getMessage() != null ? ex.getMessage() : "Erreur inattendue");
            }
        });
    }

    /** La sous-classe effectue le calcul et renvoie la ligne d'historique */
    protected abstract void doCalculate();
}
