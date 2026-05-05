# Documentation : Mvc.java

**Rôle global :** 
C'est la classe "Launcher", le cœur d'amorçage. C'est la classe principale du programme qui contient le traditionnel `public static void main`, requis par Java pour démarrer le logiciel.

**Fonction :**
- `main(String[] args)` : Ne fait qu'une seule chose, elle appelle le constructeur du `MainMenu` mais en le glissant dans `SwingUtilities.invokeLater()`. 

**Détail hyper pro pour le professeur :** 
Il est obligatoire en Java Swing d'utiliser `invokeLater()`. Pourquoi ? Parce que Swing (le système de dessin des fenêtres) n'est pas *"Thread-Safe"* (il ne supporte pas que plusieurs processus informatiques le touchent en même temps).
Faire appel à `invokeLater` indique au système de placer la construction de la fenêtre `MainMenu` directement dans la file d'attente du thread graphique officiel de Java (le *"Event Dispatch Thread"* - EDT). Si on ne fait pas ça, l'application fonctionne la plupart du temps, mais elle peut occasionnellement subir des crashs graphiques incompréhensibles (gel de l'écran, bouton qui disparaît).
