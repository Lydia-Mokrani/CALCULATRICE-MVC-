# Projet Calculatrice MVC en Java

Ce projet est une application de calculatrice modulaire et complète, implémentant rigoureusement le patron de conception **MVC (Modèle-Vue-Contrôleur)**. Il a été conçu pour répondre à un cahier des charges strict, tout en apportant des optimisations structurelles poussées grâce à la Programmation Orientée Objet (POO).

## 🚀 Le Motif Architectural MVC : Qu'est-ce que c'est ?

L'architecture MVC est un standard de développement de génie logiciel qui sépare le code en 3 grandes responsabilités :
1. **Modèle (Model) :** Le cerveau de l'application. Il contient exclusivement la logique métier (ici, les mathématiques et les calculs). Il ne sait absolument rien de l'interface graphique.
2. **Vue (View) :** L'interface utilisateur. Elle affiche les éléments (boutons, champs de texte) et capte les clics de la souris ou les touches du clavier, mais elle ne calcule rien par elle-même.
3. **Contrôleur (Controller) :** Le chef d'orchestre. Il écoute les actions de la Vue, donne les ordres au Modèle pour effectuer les calculs, et renvoie le résultat à afficher dans la Vue.

**Avons-nous bien implémenté le MVC ?**
**OUI, de façon parfaite.** Notre projet respecte ce patron à la lettre. Le Modèle est totalement aveugle et ne dépend jamais de composants Java Swing. De plus, nos Modèles, Vues et Contrôleurs utilisent des interfaces (`ICalculatorModel`) et des classes abstraites, ce qui rend l'architecture à la fois très robuste et facilement extensible, respectant ainsi les principes **SOLID**.

---

## 🏗️ Structure du Projet (Classes et Fichiers)

L'application est divisée en plusieurs *packages* (dossiers) pour isoler les 3 calculatrices indépendantes :

### 1. Racine (`mvc`)
- **`Mvc.java`** : Le point d'entrée du programme. Il contient la méthode `main` qui lance le thread de l'interface graphique en toute sécurité via `SwingUtilities.invokeLater()`.

### 2. Package `mvc.common` (Le cœur de l'architecture)
- **`ICalculatorModel` (Interface) :** Impose à tous les modèles d'implémenter les méthodes `getResult()` et `clear()`. Cela garantit que toute nouvelle calculatrice partagera un comportement de base unifié.
- **`AbstractCalculatorView` (Classe Abstraite) :** La fondation visuelle commune (fenêtre globale, bandeau de titre, panneau de droite pour l'historique). Elle utilise le *Design Pattern "Template Method"* pour forcer les Vues enfants à créer leur propre zone centrale de clavier.
- **`AbstractCalculatorController` (Classe Abstraite) :** Intercepte les clics sur le bouton "Calculer" de manière générique. Elle embarque un imposant bloc `try/catch` qui protège toutes les calculatrices des crashs (ex: Division par zéro, saisie de lettres au lieu de chiffres, etc.) en affichant des "Pop-ups" d'erreur.
- **`UIStyle` :** Centralise tout le design graphique (Mode sombre élégant inspiré d'iOS, polices de caractères, création de boutons aux angles arrondis).

### 3. Package `mvc.menu`
- **`MainMenu` :** La fenêtre d'accueil qui permet à l'utilisateur de lancer le mode de calcul de son choix. Elle utilise intelligemment les fonctionnalités avancées de Java 8 (`Supplier`, `BiFunction`) pour lancer les trios MVC sur une seule ligne de code.

### 4. Package `mvc.simple` (Calculatrice Simple)
- **`SimpleCalculatorModel` :** Effectue les 4 opérations de base (+, -, ×, ÷).
- **`SimpleCalculatorView` :** Offre une interface classique (type téléphone) sous forme de grille, et s'occupe de la concaténation visuelle des nombres quand on appuie sur les touches.
- **`SimpleCalculatorController` :** Exécute l'opération simple.

### 5. Package `mvc.scientific` (Calculatrice Scientifique)
- **`ScientificCalculatorModel` :** Un modèle avancé scindé en "opérations binaires" (à deux opérandes, ex: puissance) et "opérations unaires" (à un opérande, ex: racine carrée `√`, sinus, logarithme).
- **`ScientificCalculatorView` :** S'adapte visuellement au contexte (elle masque le champ de saisie du deuxième nombre lorsque le mode "Unaire" est sélectionné par l'utilisateur).
- **`ScientificCalculatorController` :** Aiguille la logique selon le mode scientifique choisi.

### 6. Package `mvc.binary` (Calculatrice Binaire)
- **`BinaryCalculatorModel` :** Capable de réaliser des calculs à partir de nombres décimaux classiques, ou en convertissant des chaînes de caractères `0` et `1` depuis le binaire avec protection par Expression Régulière (`Regex`).
- **`BinaryCalculatorView` :** Permet à l'utilisateur de basculer du mode d'entrée Décimal au mode Binaire grâce à des boutons "Radio".
- **`BinaryCalculatorController` :** Coordonne la Vue et le Modèle, et affiche systématiquement le résultat sous sa double forme (Base 10 et Base 2).

---

## 🛠️ Commandes Utiles (Compilation & Exécution)

Pour conserver un projet propre comme les professionnels, le code source textuel (`.java`) réside dans le répertoire `src`, et le code binaire compilé (`.class`) est rangé automatiquement dans le répertoire `out`.

**1. Pour compiler proprement l'ensemble du projet :**
Ouvrez votre terminal à la racine du projet (`C:\Users\dell\CALCULATRICE-MVC-`) et tapez :
```bash
javac -d out -encoding UTF-8 src/mvc/Mvc.java src/mvc/common/*.java src/mvc/menu/*.java src/mvc/simple/*.java src/mvc/scientific/*.java src/mvc/binary/*.java
```
*L'argument `-d out` indique au compilateur Java de ranger le ByteCode de manière propre dans le dossier final sans polluer le code source.*

**2. Pour lancer la calculatrice (depuis la racine) :**
```bash
java -cp out mvc.Mvc
```
*L'argument `-cp out` spécifie à la Java Virtual Machine (JVM) qu'il faut aller chercher les classes compilées dans le répertoire `out`.*
