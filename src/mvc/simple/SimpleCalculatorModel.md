# Documentation : SimpleCalculatorModel.java

**Rôle global :** 
Ce fichier est le **Modèle** de la calculatrice standard. Il prend en charge l'arithmétique basique (addition, soustraction, multiplication, division).

**Attributs :**
- `private double result;` : Garde en mémoire le résultat du dernier calcul effectué. (On utilise `double` car les divisions peuvent générer des nombres à virgule).

**Fonctions / Méthodes :**
- `calculate(double a, double b, String op)` : Prend en paramètre deux nombres à virgule et un opérateur.
  - Utilise un `switch(op)` pour déterminer quelle opération mathématique faire.
  - **Détail important (tests) :** Dans le cas de la division (`÷`), elle vérifie si `b == 0`. Si c'est le cas, elle lance une erreur `ArithmeticException`. C'est exactement ce que demandait l'énoncé du projet ("en prenant en charge tous les tests possibles").
- `getResult()` et `clear()` : Méthodes imposées par l'interface `ICalculatorModel`. Permettent respectivement de lire le résultat caché en mémoire, et de le remettre à zéro.
- `format(double v)` : Permet de convertir le résultat numérique en une jolie chaîne de texte. Si le résultat est `5.0`, cette méthode s'assure d'afficher juste `"5"` pour que ce soit plus beau visuellement.
