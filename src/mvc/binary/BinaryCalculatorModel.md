# Documentation : BinaryCalculatorModel.java

**Rôle global :** 
Ce fichier représente le **Modèle** de la calculatrice binaire. C'est ici que toute la logique mathématique (additions, divisions, conversions binaire/décimal) est traitée. Il ne contient aucune logique d'affichage (pas de Java Swing).

**Attributs :**
- `private double result;` : Attribut privé qui stocke le résultat numérique interne du dernier calcul effectué en mémoire.

**Fonctions / Méthodes :**
- `calculate(String rawA, String rawB, String op, String inputMode)` : C'est le cœur du modèle. Elle prend les deux entrées texte (`rawA`, `rawB`), l'opérateur (`+`, `-`, `×`, `÷`) et le mode d'entrée (`BIN` ou `DEC`).
  - Si le mode est `BIN`, elle vérifie avec une expression régulière (`rawA.matches("[01]+")`) que ce sont bien uniquement des zéros et des uns. Sinon, elle lève une erreur.
  - Elle convertit ensuite ce texte en vrai nombre entier via `Long.parseLong(..., 2)`.
  - Elle exécute ensuite le calcul arithmétique classique (`switch (op)`).
  - Elle empêche les divisions par zéro (`ArithmeticException`).
- `getResult()` : Héritée de l'interface `ICalculatorModel`. Retourne la valeur mathématique pure `result`.
- `clear()` : Héritée de `ICalculatorModel`. Remet la mémoire `result` à 0.
- `getResultBinary()` : Convertit le résultat mathématique (qui est en base 10 dans la machine) en une chaîne de texte binaire (ex: le nombre `5` devient le texte `"101"`) via `Long.toBinaryString()`. Elle gère aussi l'ajout du signe moins `-` pour les nombres négatifs.
- `getResultDecimal()` : Formate le résultat en texte pour l'affichage (enlève les zéros inutiles).
