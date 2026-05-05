# Package : mvc.common

**Rôle global de ce dossier :**
C'est la colonne vertébrale (le Framework) de votre architecture logicielle. Il contient tout le code "mutualisé" et abstrait de votre application.

**Ce qu'il faut dire au professeur :**
*"Dans ce dossier, j'ai mis en pratique les principes d'Héritage et de Polymorphisme pour maximiser le concept DRY (Don't Repeat Yourself). Au lieu d'avoir trois Vues séparées qui redessineraient trois fois la même barre de menu et le même historique, j'ai créé une classe abstraite `AbstractCalculatorView` qui le fait une seule fois. Les Vues spécifiques des calculatrices n'ont plus qu'à hériter (`extends`) de cette classe pour profiter de ce comportement. J'ai appliqué exactement la même stratégie pour le Contrôleur afin de centraliser la capture des Exceptions (les blocs Try/Catch). Ce dossier common agit donc comme la 'Mère' de toutes mes calculatrices."*
