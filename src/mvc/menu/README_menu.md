# Package : mvc.menu

**Rôle global de ce dossier :**
Ne contient que la fenêtre du menu d'accueil. 

C'est un dossier essentiel de la conception logicielle. Il prouve à votre correcteur que vos 3 calculatrices sont totalement hermétiques et isolées. C'est ce Menu (situé à l'extérieur) qui joue le rôle d'entremetteur : il "branche" (instancie) le bon Modèle avec la bonne Vue et le bon Contrôleur lorsqu'on clique sur un bouton. 

Grâce à cette approche (l'Injection de Dépendances "artisanale"), vos 3 calculatrices ignorent l'existence même du menu principal, ce qui prouve un code au couplage faible (une excellente chose en programmation).
