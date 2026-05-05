# Documentation : BinaryCalculatorView.java

**Rôle global :** 
C'est la **Vue** de la calculatrice binaire. Elle définit ce que l'utilisateur voit à l'écran (les champs pour taper, les listes déroulantes, les boutons radio). Elle hérite de la classe commune `AbstractCalculatorView` pour ne pas avoir à recoder la fenêtre de base.

**Attributs (Les composants graphiques) :**
- `display` (JLabel) : Affiche le gros résultat final à l'écran.
- `exprLabel` (JLabel) : Le petit texte au-dessus du résultat (qui montre l'équivalent binaire).
- `fieldA`, `fieldB` (JTextField) : Les deux zones de texte où l'utilisateur tape ses opérandes.
- `opBox` (JComboBox) : Le menu déroulant pour choisir l'opération (+, -, ×, ÷).
- `binBtn`, `decBtn` (JRadioButton) : Les petits boutons ronds (Boutons Radio) pour dire si on est en train de taper en base 2 (Binaire) ou base 10 (Décimal).

**Fonctions / Méthodes :**
- `BinaryCalculatorView()` *(Constructeur)* : Appelle le parent `super(...)` pour mettre le bon titre et la bonne couleur. Elle groupe les boutons radio dans un `ButtonGroup` pour qu'on ne puisse en cocher qu'un seul à la fois, puis elle appelle `init()`.
- `buildCalcPanel()` : C'est la méthode imposée par la classe mère (`@Override`). Elle construit spécifiquement la grille centrale (le formulaire `fieldA`, `opBox`, `fieldB` et le bouton "Calculer").
- **Les "Getters" (Conçus pour être lus par le Contrôleur) :**
  - `getInputA()`, `getInputB()` : Lisent ce que l'utilisateur a écrit.
  - `getOperation()` : Lit l'opération choisie dans le menu.
  - `getInputMode()` : Renvoie le texte `"BIN"` si `binBtn` est coché, sinon renvoie `"DEC"`.
- `setDisplay(String dec, String bin)` : Demande à la vue de changer le texte de ses labels pour afficher le résultat final (appelée par le Contrôleur à la fin).
