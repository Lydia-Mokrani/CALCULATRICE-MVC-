package mvc.common;

/**
 * Interface commune à tous les modèles de la calculatrice.
 * Permet de standardiser l'accès aux résultats et la réinitialisation de l'état.
 */
public interface ICalculatorModel {
    
    /**
     * Retourne le résultat numérique de la dernière opération.
     */
    double getResult();

    /**
     * Réinitialise l'état interne du modèle.
     */
    void clear();
}
