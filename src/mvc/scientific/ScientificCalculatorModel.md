# Documentation : ScientificCalculatorModel.java

**Rôle global :** 
Le **Modèle** pour la calculatrice scientifique. C'est ici que sont calculées les fonctions complexes demandées par votre exercice (sin, cos, sqrt...).

**Attributs :**
- `result` (double) : Garde le dernier résultat en mémoire.
- `BINARY_OPS` et `UNARY_OPS` (tableaux de chaînes, public static) : Ces listes ("+", "-", "sin", "cos") sont écrites dans le modèle car ce sont des données "métier", mais elles sont récupérées par la Vue pour construire les menus déroulants.

**Fonctions / Méthodes :**
- `calculateBinary(double a, double b, String op)` : Gère tous les calculs qui ont besoin de **deux opérandes** (comme `a + b`, ou `a à la puissance b`).
- `calculateUnary(double a, String op)` : Gère tous les calculs qui ne nécessitent qu'**un seul nombre**. C'est ici que la classe appelle la librairie standard Java `Math` (`Math.sin()`, `Math.sqrt()`). C'est aussi ici que le Modèle bloque les aberrations mathématiques (ex: racine carrée d'un nombre négatif, ou tangente impossible) en lançant des `ArithmeticException`.
- `getResult()`, `clear()` : Héritées de `ICalculatorModel` (obligatoires).
- `format()` : Transforme le résultat en texte. Les calculs scientifiques génèrent beaucoup de décimales (ex: sinus), la méthode est configurée pour conserver les chiffres importants ou afficher l'infini (`+∞`).
