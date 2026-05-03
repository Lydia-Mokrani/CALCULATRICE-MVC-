# Analyse du Projet : Calculatrice MVC

## Introduction
Le projet `CalculatorMVC` est une implémentation robuste, modulaire et très bien structurée d'une calculatrice multi-modes en Java. Il respecte rigoureusement le patron de conception **Modèle-Vue-Contrôleur (MVC)**, en s'appuyant intelligemment sur l'héritage et l'encapsulation pour éviter toute redondance de code.

## Analyse Fichier par Fichier

### 1. Structure de base & Point d'entrée
- **`Mvc.java`** : C'est le point d'entrée de l'application. Le code est concis et lance la fenêtre `MainMenu` via `SwingUtilities.invokeLater`, ce qui est la bonne pratique absolue en Java Swing pour garantir la sécurité des threads de l'interface graphique.

### 2. Package `mvc.common` (Architecture de Base & Style)
- **`AbstractCalculatorView.java`** : La classe mère abstraite de toutes les vues. Elle hérite de `JFrame` et construit le squelette commun : l'en-tête, le panneau de centre vide et l'historique à droite. Elle exige des sous-classes qu'elles définissent leur propre zone centrale via la méthode `buildCalcPanel()`. L'approche consistant à obliger l'appel à `init()` à la fin des constructeurs dérivés est très bien pensée pour éviter les problèmes d'initialisation.
- **`AbstractCalculatorController.java`** : Classe abstraite fournissant le squelette des contrôleurs, en gardant une référence commune sur la vue. Elle impose l'implémentation de `doCalculate()`.
- **`UIStyle.java`** : Une classe utilitaire brillante. Elle centralise les thèmes (mode sombre iOS, couleurs, polices) et offre des composants customisés (boutons ronds, champs arrondis) en surchargeant la méthode `paintComponent`. Elle allège énormément les classes de vue et garantit la cohérence visuelle.

### 3. Package `mvc.menu` (Menu Principal)
- **`MainMenu.java`** : Affiche les trois boutons permettant de choisir sa calculatrice. L'instanciation des trios (Modèle, Vue, Contrôleur) lors du clic sur un bouton est isolée, respectant le fait que les calculatrices sont des sous-applications indépendantes.

### 4. Package `mvc.simple` (Calculatrice Simple)
- **`SimpleCalculatorModel.java`** : Gère la logique des opérations basiques (+, -, ×, ÷). Il anticipe parfaitement les problèmes, par exemple en jetant une `ArithmeticException` lors d'une division par zéro.
- **`SimpleCalculatorView.java`** : Elle recrée l'interface de calculatrice standard avec un pavé numérique. La logique de saisie "au clic" (concaténation de chaîne pour former un nombre) est encapsulée ici. Cela permet d'envoyer uniquement les valeurs finales "propres" au contrôleur.
- **`SimpleCalculatorController.java`** : Relie la vue simple et le modèle lors du clic sur la touche "=", et capte les erreurs d'entrée ou de calcul pour les afficher sans faire crasher l'application.

### 5. Package `mvc.scientific` (Calculatrice Scientifique)
- **`ScientificCalculatorModel.java`** : Modèle complexe séparé en opérations "binaires" (2 opérandes, comme "pow") et "unaires" (1 opérande, comme "sin" ou "√"). Il gère parfaitement les limites mathématiques (racines de nombres négatifs, tangentes non définies).
- **`ScientificCalculatorView.java`** : Propose un affichage par "formulaire" (Champs de texte et listes déroulantes `JComboBox`). Très astucieux : le bouton radio met à jour l'interface dynamiquement pour cacher la seconde zone de texte (champ B) en mode Unaire.
- **`ScientificCalculatorController.java`** : Se charge de lire les valeurs, d'appeler la bonne fonction du modèle (binaire ou unaire) et de formater l'historique en conséquence.

### 6. Package `mvc.binary` (Calculatrice Binaire)
- **`BinaryCalculatorModel.java`** : Réalise des calculs que la source soit décimale ou binaire. L'utilisation d'expressions régulières (`[01]+`) pour valider les entrées binaires avant calcul est très pertinente.
- **`BinaryCalculatorView.java`** : Interface avec un formulaire de saisie, un sélecteur d'opérateurs et un "switch" pour passer la saisie du mode Décimal au mode Binaire.
- **`BinaryCalculatorController.java`** : Contrôle l'exécution et veille à demander à la vue d'afficher à la fois la réponse en décimal et en base 2 (via `getResultBinary`).

## Ce que je pense du projet

Mon avis sur le projet est **très positif**, voici pourquoi :

1. **Architecture MVC exemplaire :** Les responsabilités sont parfaitement réparties. Le modèle s'occupe à 100% du calcul et des mathématiques, la vue à 100% de l'affichage (Swing) et le contrôleur assure la communication. Le Modèle est complètement aveugle à la Vue, respectant les normes.
2. **Utilisation puissante de la POO :** L'usage de `AbstractCalculatorView` correspond au *Design Pattern* **Template Method**. Tout le code redondant (création de la fenêtre, bandeau titre, panneau d'historique) est écrit une seule fois.
3. **Robustesse :** Tous les scénarios inattendus (Division par 0, champs vides, lettres au lieu de nombres, racines carrées négatives) sont correctement interceptés via `try...catch` dans les contrôleurs et affichent un message `JOptionPane` au lieu de planter.
4. **Design Visuel :** `UIStyle.java` donne à l'application un design moderne (Dark Mode "Apple/iOS"). C'est une excellente valeur ajoutée par rapport aux interfaces Java Swing de base qui font très années 90.

**Conclusion :** 
Le projet est un excellent exemple de génie logiciel en Java. Si vous deviez ajouter une "Calculatrice Financière", l'architecture permettrait de le faire simplement en créant trois nouvelles classes et en les branchant au menu principal, sans modifier le code existant.
