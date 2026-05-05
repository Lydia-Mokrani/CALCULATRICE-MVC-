# Documentation : SimpleCalculatorView.java

**Rôle global :** 
C'est la **Vue** de la calculatrice de base. C'est la plus complexe des interfaces car elle recrée un véritable pavé numérique interactif (boutons 0 à 9), au lieu d'utiliser de simples formulaires texte comme les autres calculatrices. Elle hérite de `AbstractCalculatorView`.

**Attributs :**
- `displayLabel`, `expressionLabel` : Les écrans (étiquettes) pour afficher le résultat géant et le petit historique de frappe au-dessus.
- `pendingValue`, `pendingOp`, `currentInput` : Variables pour mémoriser temporairement ce que l'utilisateur est en train de taper avant d'appuyer sur "Calculer". (Ex: je tape "1" puis "2", ça forme "12").
- `firstNum`, `secondNum`, `operation` : Données finales et propres, prêtes à être envoyées au contrôleur.

**Fonctions / Méthodes :**
- `SimpleCalculatorView()` *(Constructeur)* : Paramètre la taille des textes et appelle `init()`.
- `buildCalcPanel()` : Construit la grille "5x4" iOS. C'est là qu'elle place tous les boutons (`0` à `9`, `+`, `-`, `AC` pour tout effacer, etc.). Elle lie chaque bouton à une petite méthode interne (ex: quand on clique sur `5`, elle appelle `digitPressed("5")`).
- **Logique de clavier (Méthodes internes privées) :**
  - `digitPressed()`, `dotPressed()` : S'occupe de la concaténation de texte (coller le chiffre 5 derrière le chiffre 2 pour faire 25).
  - `opPressed()` : Se déclenche quand on appuie sur `+` ou `-`. Elle sauvegarde le premier nombre en mémoire.
  - `equalsPressed()` : La méthode la plus importante. Quand on clique sur `=`, elle fige les nombres finaux (`firstNum`, `secondNum`) et prévient le Contrôleur que c'est l'heure de faire son travail.
- **Les "Getters" (pour le Contrôleur) :**
  - `getFirstNumber()`, `getSecondNumber()`, `getOperation()` : Permettent au Contrôleur d'aspirer les données finales.
