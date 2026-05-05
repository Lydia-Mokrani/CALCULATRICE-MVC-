# Documentation : ScientificCalculatorController.java

**Rôle global :** 
Le **Contrôleur** qui met en relation la Vue et le Modèle scientifiques. Il sert d'aiguilleur sur les rails d'un train.

**Fonctions / Méthodes :**
- `ScientificCalculatorController(...)` (Constructeur) : Lie la vue et le modèle entre eux. L'écouteur (le clic sur le bouton) est accroché grâce à la classe mère.
- `doCalculate()` : S'exécute lors du clic du bouton "Calculer". 
  Le contrôleur observe l'état de la Vue (avec son `if / else`) pour savoir de quel calcul il s'agit :
  1. Si `view.isBinaryMode()` est vrai : Le contrôleur va demander deux nombres à la Vue et fait appel à la fonction `calculateBinary()` du Modèle.
  2. Sinon : Il ne demande qu'un seul nombre à la Vue et fait appel à `calculateUnary()`.
  
  Grâce à ce Contrôleur, le Modèle ne s'occupe que des mathématiques, et la Vue ne s'occupe que de montrer et cacher des cases. L'intelligence décisionnelle est au bon endroit !
