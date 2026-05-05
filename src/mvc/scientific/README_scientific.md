# Package : mvc.scientific

**Rôle global de ce dossier :**
Répond à la troisième consigne de votre exercice : *"Réalisez une calculatrice scientifique qui permet de faire les mêmes opérations, mais aussi sin, cos, sqrt"*. Ce dossier est une application 100% autonome.

**Particularité de la démarche MVC ici :**
Ce package démontre toute la puissance de l'architecture MVC. Contrairement à la calculatrice simple (qui a un parcours très direct), la calculatrice scientifique possède deux "voies" de fonctionnement très différentes : l'Unaire (un seul nombre, ex: √9) et le Binaire (deux nombres, ex: 9²).

C'est là que le **Contrôleur** prend tout son sens. La Vue se contente de se re-dessiner selon les clics de l'utilisateur (afficher ou masquer le champ du 2ème nombre). Le Modèle contient ses formules mathématiques inactives. C'est uniquement le Contrôleur qui décide de dire : *"Vu que l'utilisateur est en mode Unaire, je vais extraire un seul nombre de la Vue, et l'envoyer à telle fonction précise du Modèle"*.

**Ce qu'il faut dire au professeur :**
*"J'ai développé la calculatrice scientifique pour illustrer le rôle décisionnel du Contrôleur. Il gère le branchement conditionnel (le if/else) pour appeler la bonne méthode du Modèle, laissant ainsi la Vue totalement ignorante des calculs."*
