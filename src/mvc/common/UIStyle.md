# Documentation : UIStyle.java

**Rôle global :** 
C'est la "Feuille de style" (comme un fichier `.css` en développement Web) de votre application logicielle Java. 

**Pourquoi ce fichier est-il essentiel ?**
L'interface de base de Java Swing est souvent jugée très rustique. Pour obtenir un design moderne (Mode sombre, boutons aux angles doucement arrondis, typographie épurée "SF Pro" façon Apple), il faut écrire des centaines de lignes de code très répétitives (redéfinir le fond, les bordures, le format des polices). 

En regroupant toutes ces constantes esthétiques (couleurs HEX, variables de Fonts, et "Factories" de création de boutons personnalisés) dans le fichier statique `UIStyle`, on obtient deux gains majeurs :
1. **Lisibilité :** On ne pollue pas la logique métier de la calculatrice avec du code de peinture.
2. **Maintenabilité :** Si l'on souhaite changer la couleur principale de l'application du bleu au rouge, on ne modifie qu'une seule ligne dans ce fichier, et toute l'application (Menu, Scientifique, Binaire) change de couleur instantanément.
