# Documentation : SimpleCalculatorController.java

**Rôle global :** 
Le **Contrôleur** minimaliste pour la calculatrice de base. Il s'occupe de faire réagir le système lorsque la `SimpleCalculatorView` signale que le bouton "=" a été cliqué.

**Attributs :**
- `view` : Référence vers le pavé numérique graphique.
- `model` : Référence vers les mathématiques de base.

**Fonctions / Méthodes :**
- `SimpleCalculatorController(view, model)` *(Constructeur)* :
  Il stocke le Modèle et la Vue pour pouvoir s'en servir plus tard. L'accroche de l'écouteur se fait automatiquement dans la classe parente `super(view)`.
- `doCalculate()` :
  Méthode déclenchée par le clic final. Son exécution est très linéaire :
  1. Il demande à la Vue le nombre 1 (`a`), le nombre 2 (`b`) et l'opérateur (`op`).
  2. Il les fournit au Modèle via `model.calculate(a, b, op)`. (Si à ce stade on divise par zéro, le Modèle jette une erreur qui sera attrapée par le parent).
  3. Il demande au Modèle le résultat (`model.getResult()`).
  4. Il renvoie le résultat à la Vue (`view.setResult(result)`) pour l'affichage à l'écran.
  5. Il ajoute une belle ligne dans l'historique visuel à droite.
