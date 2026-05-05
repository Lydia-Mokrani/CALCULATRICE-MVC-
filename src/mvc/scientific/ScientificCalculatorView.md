# Documentation : ScientificCalculatorView.java

**Rôle global :** 
C'est la **Vue** scientifique. Son apparence est radicalement différente de la vue Simple : c'est un "Formulaire" de saisie (on tape les chiffres au clavier dans des cases). Elle hérite de `AbstractCalculatorView`.

**Attributs :**
- `binOpBox`, `uniOpBox` (`JComboBox`) : Ce sont les deux listes déroulantes contenant les symboles des opérations (l'une pour le binaire, l'autre pour l'unaire).
- `binRadio`, `uniRadio` (`JRadioButton`) : Les boutons permettant à l'utilisateur de choisir s'il fait un calcul à 2 nombres ou à 1 nombre.

**Fonctions / Méthodes :**
- `ScientificCalculatorView()` (Constructeur) : Appelle `init()` pour construire l'écran. 
- `buildCalcPanel()` : Construit le formulaire. Elle utilise le `GridBagLayout` (le gestionnaire de placement le plus puissant et complexe de Java Swing) pour aligner proprement les labels et les champs de texte en colonnes. Elle superpose volontairement les listes déroulantes `binOpBox` et `uniOpBox` à la même place.
- `updateMode()` : La méthode magique de l'interface. Quand l'utilisateur clique sur le bouton "Unaire" (`sin`, `cos`), la Vue s'adapte dynamiquement en **masquant** (`setVisible(false)`) le champ du deuxième nombre et la liste déroulante des opérateurs normaux, pour ne laisser que le champ A.
- Les **Getters** : Permettent au Contrôleur d'aspirer les textes tapés par l'utilisateur une fois qu'il clique sur "Calculer".
