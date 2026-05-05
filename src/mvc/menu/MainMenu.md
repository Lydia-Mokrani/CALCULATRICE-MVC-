# Documentation : MainMenu.java

**Rôle global :** 
C'est la porte d'entrée visuelle de l'application. Elle n'appartient à aucune calculatrice spécifique. C'est un menu (un lanceur d'applications) qui permet à l'utilisateur de cliquer sur 3 boutons pour démarrer l'un des 3 trios MVC de son choix.

**Fonctions / Méthodes :**
- `MainMenu()` (Constructeur) : Dessine la petite fenêtre centrale avec les 3 gros boutons ("Simple", "Binaire", "Scientifique").
- `makeMenuBtn()` : Une méthode utilitaire privée très pratique qui évite d'avoir à copier-coller 3 fois les mêmes lignes de code pour peindre et configurer les 3 boutons de lancement.
- `openCalculator(...)` : **C'est le point de génie de l'architecture de ce code.** 
  C'est une méthode "Générique" extrêmement avancée en Java (Java 8). Au lieu d'avoir trois méthodes différentes (`openSimple`, `openBinary`...) qui feraient les mêmes choses, cette unique fonction prend en paramètre des "Recettes de fabrication" (Les `Supplier` et `BiFunction`). 
  Quand on clique sur le bouton Simple, la méthode s'auto-configure pour instancier le `SimpleModel`, la `SimpleView`, les lier au `SimpleController`, puis faire apparaître la fenêtre (`setVisible(true)`).
