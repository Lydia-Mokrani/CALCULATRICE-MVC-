# Documentation : ICalculatorModel.java

**Rôle global :** 
C'est une **Interface** (un contrat pur). Elle oblige formellement toutes les classes qui prétendent être des "Modèles de Calculatrice" à posséder obligatoirement certaines méthodes.

**Fonctions / Méthodes (Le Contrat) :**
- `double getResult()` : Tout modèle doit être capable de cracher un résultat numérique final.
- `void clear()` : Tout modèle doit pouvoir effacer et réinitialiser sa mémoire.

**Détail pour le professeur (Polymorphisme) :**
Créer cette interface est la fondation d'une architecture orientée objet respectant le principe **"D" de SOLID** (Dependency Inversion Principle). Cela permet à notre système central de manipuler les Modèles de façon abstraite, sans avoir à chercher s'ils sont simples, binaires ou scientifiques. L'architecture dit juste : *"Je manipule un objet qui respecte le contrat `ICalculatorModel`, donc je sais de façon certaine qu'il a une méthode `getResult()` sans me soucier de la façon dont le calcul a été fait en interne"*. C'est de l'Abstraction pure.
