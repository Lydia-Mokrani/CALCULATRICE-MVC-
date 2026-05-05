# Documentation : BinaryCalculatorController.java

**Rôle global :** 
Le **Contrôleur** fait le pont entre `BinaryCalculatorView` (l'interface utilisateur) et `BinaryCalculatorModel` (la logique). C'est lui qui orchestre le flux d'informations lorsqu'on lance un calcul.

**Attributs :**
- `view` : Référence vers l'interface binaire (pour lire les saisies de l'utilisateur).
- `model` : Référence vers le cerveau binaire (pour lancer le calcul).

**Fonctions / Méthodes :**
- `BinaryCalculatorController(BinaryCalculatorView view, BinaryCalculatorModel model)` *(Constructeur)* :
  Sauvegarde les références `view` et `model`. Il appelle aussi le constructeur parent `super(view)`, ce qui est **très important** car c'est la classe parente qui va accrocher le "Listener" (l'écouteur de clic) sur la vue.
- `doCalculate()` : 
  Cette méthode est appelée **automatiquement** quand le bouton "Calculer" est pressé (grâce au parent). Voici sa séquence exacte (très utile pour l'expliquer au prof !) :
  1. Elle récupère les entrées de la Vue en appelant les Getters de la vue (`getInputA()`, etc.).
  2. Elle vérifie si les champs sont vides. Si c'est le cas, elle lance une exception (qui sera capturée par le parent pour afficher un pop-up d'erreur).
  3. Elle donne les données brutes au Modèle (`model.calculate(a, b, op, mode)`).
  4. Elle demande au Modèle le résultat décimal (`getResultDecimal()`) et binaire (`getResultBinary()`).
  5. Elle ordonne à la Vue d'afficher ces deux résultats à l'écran (`view.setDisplay(...)`).
  6. Enfin, elle construit une phrase propre et l'ajoute dans le panneau d'Historique (`view.addToHistory(...)`).
