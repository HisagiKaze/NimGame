RAPPORT : Projet de programmation : Jeu de Nim

* Le jeu de Nim est un jeu d'allumette selon lequel les joueurs retire un nombre d'allumette ( 3 max) tout en évitant de retirer la dernière allumette. C'est allumettes forment dans l'ensemble une structure pyramidale dont le sommet contient une allumette et les lignes suivante soit n ligne qui contient 2 * n + 1 allumette selon la ligne.
Le but du projet est redéfinir ce jeu en java en ajoutant deux Intelligences Artificelles une naive et l'autre intelligente.

* Ma partie à été de codé l'IA naïve et smart en utilisant la méthode des listes pour les choix des coups de l'IA et des noyaux pour que l'IA intelligente choisisse toujours le bon nombre d'allumette à retirer en fonction du coup du joueur.

Je vais enfin décrire mes méthodes et les documentation qui m'en aidé pour créer l'IA naïve et intelligente :

MaillonM.java : C'est une class permettant de créer des maillon contenant des Moves (coups possible de l'IA), permettant ainsi la création de liste des coups possible de l'IA naîve et intelligente.

LCM.java : Cette classe permet la création des listes chaînées permettant de définir les coups possible de l'IA en fonction de la configuration du tableau d'allumette donc de ses lignes et du nombre d'allumette par ligne.

IA_naive.java : Contient les classes LCM et MaillonM grâce à une méthode elle peut choisir aléatoirement ses coups en fonction d'un tableau d'allumette.

MaillonNoyau.java : C'est une autre class permettant aussi de créer des maillons dont les valeurs peuvent contenir des noyaux ou des sommets afin d'indiquer à l'IA intelligente le nombre d'allumette à retirer pour atteindre le noyau.

Graphe.java : Elle créait des liste chaîne de noyau et de sommet , une des méthode de cette classe permet de retirer les sommet menant au noyaux le plus proche afin de retirer le nombre d'allumette nécessaire pour atteindre celui-ci en fonction du nombre d'allumette restante.

Ia_intel : Création de l'IA intelligente une méthode permet de choisir les bon coups dont un est renvoyé aléatoirement grâce au classes LCM, MaillonNoyau, MaillonM et Graphe.

Nim.java : Contient deux méthode une our jouer avec l'IA naïve et l'autre pour jouer avec l'IA intelligente , c'est une des deux méthodes est activé selon le choix de l'utilisateur. Cette utilisateur après avoir fini de jouer à une des deux difficulté pourra rejouer ou non une des difficulté selon son choix.

* Dans l'ensemble la gestion des coups de l'IA naïve et smart à été géré par des liste chainé qui se renouvelle après chaque coup lancé en fonction du tableau d'allumette et du nombre d'allumette restante de même pour la gestion des noyaux et des sommets. Les noyaux sont stocké dans des listes chaîné en fonction du nombre d'allumette , une méthode dans la classe Graph permette de créer des maillon qui contient les sommet du noyaux le plus proche. Par contre dans certains cas (si c'est un nombre impairs par exemple), l'IA intelligente sera obligé de retirer une ou deux allumette car hors de portée du noyau. Pour coder cela je me suis servi de la documentation des intertices de nim donner sur l'énnoncé du TP. 