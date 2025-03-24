
# Introduction
Le présent rapport décrit la conception et l'implémentation d'un jeu de type MasterMind, un jeu de logique où le joueur doit deviner une combinaison de pions de couleur, seul ou en multi-joueur. Ce projet consiste à créer une
version informatisée du jeu, en permettant notamment la personnalisation des paramètres tels que le nombre de pions et de couleurs, ainsi que le nombre de tentatives autorisées. De plus, une interface graphique via Awt, Swing a été implémenté, ainsi qu'une fonction de sauvegarde et de chargement de partie en chier Json.

# Programme Principal
Le projet possède 3 dossiers : *src*, *build*, *media* qui contient les png utilisés,
et *lib* qui contient la librairie Json. La compilation du jeu et le lancement se fait respectivement avec les commandes :
```
javac -cp lib/json-simple.jar -d build/ src/*.java
```
et
```
java -cp lib/json-simple.jar:build GUI
```
Pour l'affichage du jeu, le choix d'une interface graphique a été fait, via
Swing, Awt et du Json pour la sauvegarde et la charge d'une partie. La classe
GUI extends JFrame, permet l'affichage d'une fenêtre graphique, possède le
main principal et lance la page d'accueil.
