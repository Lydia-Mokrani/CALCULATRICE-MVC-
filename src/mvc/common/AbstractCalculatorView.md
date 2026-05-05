# Documentation : AbstractCalculatorView.java

**Rôle global :** 
C'est la **Classe Mère** (la maman) de TOUTES les Vues de l'application. Elle contient tout le code graphique partagé pour ne jamais avoir à recréer la fenêtre de zéro dans les sous-classes (Elle assure le respect du Principe *DRY : Don't Repeat Yourself*).

**Attributs :**
- `historyArea` : Une grande zone de texte collée à droite, mutualisée pour toutes les calculatrices afin d'y afficher l'historique de tous les calculs de la session.
- `calcListener` : L'écouteur de clic (le déclencheur), prêt à être utilisé par le Contrôleur.

**Fonctions / Méthodes :**
- `AbstractCalculatorView(...)` *(Constructeur)* : Dessine le squelette (La barre du haut avec le bouton de retour au menu, le titre, et le panneau d'historique).
- `buildCalcPanel()` : **C'est la fonction la plus brillante de la classe.** Elle est déclarée `abstract protected`. Cela signifie que la classe mère dessine le contour de l'application, mais laisse un "trou noir" au milieu. Elle exige que ce soient ses enfants (Les Vues Simple, Scientifique, etc.) qui codent cette méthode pour remplir ce vide. C'est l'illustration exacte du *Design Pattern* **Template Method**.
- `init()` : Assemble les blocs (le haut, la droite, le milieu généré par l'enfant) et rend la fenêtre visible.
- `addCalculateListener()` : Point d'ancrage pour le Contrôleur.
- `lbl()`, `styleCombo()`, `styleRadio()` : Des "Helper methods" (méthodes utilitaires) qui permettent de créer des composants graphiques au bon format sans dupliquer 10 lignes de configuration à chaque fois.
