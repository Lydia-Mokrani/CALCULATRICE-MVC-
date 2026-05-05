# Package : mvc.binary

**Rôle global de ce dossier :**
Ce dossier (package) contient **exclusivement** les classes nécessaires au fonctionnement de la **Calculatrice Binaire**. 

**Philosophie POO & MVC :**
Pourquoi isoler ces fichiers dans un dossier à part ?
Dans une architecture logicielle propre (basée sur les principes *SOLID*, et plus précisément le *Single Responsibility Principle*), chaque fonctionnalité majeure doit vivre de manière indépendante. 

Le calcul binaire possède ses propres règles complexes (les nombres ne peuvent contenir que des 0 et des 1, il faut gérer des modes d'entrée via des boutons radio). Si nous avions mélangé cela dans la calculatrice "Simple", le code serait devenu un véritable plat de spaghettis (rempli de conditions `if(modeBinaire)` partout).

Ici, nous avons un **Trio MVC parfaitement indépendant** :
- `BinaryCalculatorModel` : Ne sait faire que du calcul binaire.
- `BinaryCalculatorView` : Affiche une interface spécialement pensée pour le binaire.
- `BinaryCalculatorController` : Fait parler ces deux éléments ensemble.

**Ce qu'il faut dire au professeur :**
*"J'ai séparé la calculatrice binaire dans son propre package MVC pour assurer la modularité. De cette façon, si je supprime entièrement le dossier 'binary' du projet, le reste de l'application (calculatrice simple et scientifique) continuera de compiler et de fonctionner sans aucune erreur."*
