# Documentation : AbstractCalculatorController.java

**Rôle global :** 
C'est la **Classe Mère** de TOUS les Contrôleurs. Elle joue le rôle d'un "Filet de sécurité" gigantesque pour toute l'application.

**Fonctions / Méthodes :**
- `AbstractCalculatorController(AbstractCalculatorView view)` *(Constructeur)* : 
  **C'est la tour de contrôle.** Dès qu'un contrôleur enfant (ex: `SimpleCalculatorController`) est créé, ce parent s'initialise et "branche" un Listener sur la Vue. Lorsque le bouton est cliqué, c'est ce parent qui exécute un énorme bloc `try / catch` :
  - `try` : Il ordonne à l'enfant d'exécuter sa propre logique (`doCalculate()`).
  - `catch (ArithmeticException e)` : Si, pendant son travail, l'enfant (ou le modèle) tente de diviser par zéro, le code "plante", mais l'erreur remonte ici. Le parent l'intercepte et affiche un pop-up rouge "Erreur Mathématique". L'application ne crashe pas.
  - `catch (Exception e)` : Pareil, si l'utilisateur a écrit du texte au lieu d'un chiffre (ce qui génère une `NumberFormatException`), le parent l'attrape et affiche une erreur de saisie.

- `doCalculate()` : Méthode `abstract protected`. Le parent force les Contrôleurs enfants à définir leur propre façon de s'exécuter, sachant que le parent protège l'appel derrière ses boucliers d'exceptions.
