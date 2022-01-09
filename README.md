# SIMULATION BANQUE

Il s’agit de simuler le fonctionnement d’une banque contenant un nombre fixe de caissiers, et
recevant des clients qui arrivent de maniere pseudo-aleatoire. Lorsqu’un client arrive, si un caissier est libre il prend en charge le client, sinon le client prend place dans une file d’attente (supposee commune a tous les caissiers, representee par exemple par un systeme de tickets numerotes en ordre croissant).

Le but de la simulation est de fournir des resultats statistiques sur les differents acteurs de la simulation. Pour cela, on donne en entree de la simulation:

- La duree estimee de la simulation
- Le nombre de caissiers
- Le temps moyen de service de chaque caissier
- Le temps moyen entre deux arrivees successives de clients

On souhaite obtenir, a la fin de la simulation, les resultats suivants :

- La duree reelle de la simulation
- Les longueurs maximale et moyenne de la file d’attente
- Le nombre de clients servis (au total, et par caissier)
- Le taux d’occupation de chque caissier
- Le temps moyen d’attente d’un client dans la file

## Membre du projet

- Ciciliano ALTMANN
- Vincent OUSMANE
- Philippe LAROQUE (Encadrant)

## Comment lancer le programme

- Executer le fichier JAR nommé : simulationbank.jar

<img src="./screechot.png">
