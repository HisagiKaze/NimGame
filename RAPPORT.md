# NimTP6G6
**Projet Informatique Semestre 2**

Le sujet est de re-créer le jeu du Nim en Java.
Un plateau contenant un certains nombre d'allumettes sur chaque ligne (en piramide),
et chaque joueur pouvant retirer un certain nombre d'allumettes à chaque tour.
Celui qui prendra la dernière allumette aura perdu.

**Nim.java** :
    *Contient le main. Il appelle toutes les autres fonctions pour jouer au Nim.*

**Console.java** :
    *Affiche sur la sortie standard et intéragit avec le(s) utilisateur(s).*
    
**GameState.java** :
    *Contient l'etat actuel du jeu et le nombre de coup joués.*

**Board.java** :
    *Contient le plateau de jeu, et verifie si un coup est jouable.*

**Move.java** :
    *Un objet "coup", contenant une ligne et un nombre d'allumette(s).*

**IA.java** :
    *Créer la liste des coups possible puis joue un coup "naïf" (aléatoire).*

**HumanPlayer.java** :
    *Contient le d'un joueur, son nombre de victoire et l'adresse du second joueur.*