import java.util.Scanner;
import java.util.ArrayList;

/**
 * Gére l'affichage et la saisie
 * @author  Cédric et Paul-Aurian
 */
class Console
{
/**
 * Demande au joueur de saisir le nombre de lignes du plateau 
 * et retourne cet entier.
 * @return    Nombre de ligne du plateau.
 */
	public static int getSize()
	{
		int 			boardSize;

		boardSize = InputMismatchException();
		return (boardSize);
	}

/**
 * Recupere le nom des joueurs.
 * @param i Nombre de joueur (1 ou 2)
 * @return Un tableau de deux joueurs.
 */
	public static HumanPlayer getName(int i)
	{
		Scanner			sc;
		HumanPlayer 	player1;


		System.out.println("Merci d'entrer le nom du ou des joueurs\n(séparés par un espace ou un retour à la ligne si vous ne jouez pas contre une IA) :");
		sc = new Scanner(System.in);
		player1 = new HumanPlayer(sc.next());
		if (i == 2)
		{
			HumanPlayer player2;

			player2 = new HumanPlayer(sc.next());
			player1.setNext(player2);
			player2.setNext(player1);
		}
		return (player1);
	}

/**
 * Demande au joueur de saisir un coup sous la forme ’m n’ ou ’m’ 
 * est la ligne et ’n’ est le nombre d’allumettes.
 * Et vérifie qu'il entre bien deux INTEGERs.
 * @param name	Nom du joueur courrant
 * @return Move 	Renvoie le coup jouer par le joueur
 */
	public static Move getMove(String name)
	{
		Scanner 		sc;
		boolean			btest;
		Move 			currentMove;
		int 			line;
		int 			match;

		System.out.println("C'est à " + name + " de jouer :");
		System.out.print("Entrez votre coup sous la forme \'m\' \'n\' où ");
		System.out.println("\'m\' est la ligne et \'n\' est le nombre d'allumettes.");

		sc = new Scanner(System.in);
		btest = false;
		line = -1;
		match = -1;
		do 
		{
			try 
			{
				line = sc.nextInt();
				match = sc.nextInt();
				btest = true;
			}
			catch (java.util.InputMismatchException e)
			{
				System.out.println("Merci d'entrer deux chiffres de type Integer séparés par un espace.");
				btest = false;
				String purge = sc.next();
			}
		} while (btest == false);
		sc.reset();
		return (currentMove = new Move((line - 1), match));
	}

/**
 * Affiche le plateau represente par le tableau d’entiers board où 
 * board[i] est le nombre d’allumettes restantes de la ligne i.
 * @author Cedric
 * @param board 	Nombre d'allumettes restantes sur la ligne i.
 */
	public static void ShowBoard(int[] board)
    {
	    int 			i;
	    int 			size;
	    int 			space;
	    int 			compt;

	    i = -1;
	    size = board.length - 1;
	    compt = 0;
	    while(++i < size + 1)
	    {
	    	System.out.print("Ligne " + (i + 1) + " :");
			space = 0;
			while(space++ < (size + 1 - i))
			    System.out.print(" ");
			compt = 0;
			while(compt < board[i])
			{
			    System.out.print("|");
			    compt++;
			}
			System.out.print("\n");
	    }
    }
/**
 * Affiche un message indiquant au joueur que son coup est invalide.
 * @param move Dernier coup jouer.
 */
	public static void invalidMove(Move move)
	{
		System.out.println("Le dernier coup est impossible.");
	}

/**
 * Affiche un message annoçant la victoire du joueur.
 * @param name Nom du joueur victorieux.
 */
	public static void showWinner(String name)
	{
		System.out.println("Félicitation " + name + " ! Tu remportes cette partie.");
	}

/**
 * Nettoie l'affichage du terminal.
 */
	public static void clear_term () 
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

/**
 * InputMismatchException checks if the user enter 
 * an INTEGER and not something else instead.
 * @return   Forcement un INT supérieur à 0
 */
	static int InputMismatchException () {

		int				x;
		boolean			btest;
		Scanner			sc;

		x = 0;
		btest = false;
		sc = new Scanner(System.in);
		do 
		{
			try 
			{
				System.out.print("Entrez la taille du plateau : ");
				x = sc.nextInt();
				btest = true;
			}
			catch (java.util.InputMismatchException e) 
			{
				System.out.println("Merci d'entrer un chiffre de type Integer supérieur à zéro.");
				btest = false;
				String purge = sc.next();
			}
			if (x < 0)
				btest = false;
		} while (btest == false);
		sc.reset();
		return (x);
	}

/**
 * Ecrit sur le script de jeu sur la console.
 * @param i represente les differentes etapes du jeu.
 */
	public static void script(int i)
	{
		if (i == 0)
			System.out.println("Bonjour et bienvenue dans le jeu du Nim");
		else if (i == 1)
			System.out.println("Merci. Maintenant veuillez entrer la taille de plateau souhaitée : ");
		else if (i == 2)
			System.out.println("Navré, c'est l'intelligence artificielle qui a gagné !");
	}

/**
 * Affiche le nombre de coup jouer dans la partie en cours
 * @param i INTEGER GameState.nbMove
 */
	public static void nbMovePlayed(int i)
	{
		System.out.println("Nombre de coups joués dans cette partie : " + i);
	}

	public static void printNbWins(HumanPlayer a, int b)
	{
		System.out.println("Nombre de victoires de " + a.getName() + " : " + a.getNbWins());
		System.out.println("Nombre de victoires du second joueur : " + b);
	}

/**
 * Affiche le nombre d'allumettes restantes sur le plateau
 * @param i table.getNbMatchLeft()
 */
	public static void printNbMatchLeft(int i)
	{
		System.out.println("Nombre d'allumettes restantes sur le plateau : " + i);
	}

/**
 * Demande à l'utilisateur si il souhaite rejouer une partie
 * @return vrai si il souhaite rejouer, faux sinon.
 */
	public static boolean askToPlayAgain()
	{
		Scanner			sc;
		String			str;

		System.out.println("Souhaitez-vous rejouer une partie ?\n(Écrivez \"Oui\" ou \"Non\")");
		sc = new Scanner(System.in);
		str = sc.next();
		if (str.compareToIgnoreCase("oui") == 0)
			return (true);
		if (str.compareToIgnoreCase("non") == 0)
			return (false);
		return (askToPlayAgain());
	}

/**
 * Demande si le joueur souhaite jouer contre une inteligence artificielle
 * @return -1 pour ne pas avoir d'IA, 0 pour une facile, 1 pour une difficile
 */
	public static int askAnIA()
	{
		Scanner 		sc;

		System.out.println("Souhaitez-vous jouer seul ? (Contre une intelligence artificielle) Répondez \"Oui\" si vous le souhaitez.");
		sc = new Scanner(System.in);
		if (sc.next().compareToIgnoreCase("Oui") == 0)
		{
			System.out.println("Vous avez choisi de jouer seul.");
			System.out.println("Souhaitez-vous jouer contre une IA facile ou difficile (\"facile\" ou \"difficile\")");
			if (sc.next().compareToIgnoreCase("facile") == 0)
				return (0);
			return (1);
		}
		System.out.println("Vous avez choisi de jouer contre quelqu'un.");
		return (-1);
	}

/**
 * Explique ce que vient de jouer l'IA
 * @param iaMove coup jouer par l'IA
 */
	public static void explainIaMove(Move iaMove)
	{
		clear_term();
		System.out.print("L'intelligence artificielle a retiré ");
		System.out.println("" + iaMove.getMatchNb() + " allumettes sur la ligne " + (iaMove.getLine() + 1));
	}

/**
 * Affiche sur la liste des noyaux trouvés par l'IA smart
 * sur l'entrée standard
 * @param nodesList Liste des noyaux détectés par l'IA
 */
	public static void printNodes(ArrayList<Integer> nodesList)
	{
		int 			y;

		y = -1;
		while (++y < nodesList.size())
    		System.out.println("Noyau " + y + " : " + nodesList.get(y));
	}

/**
 * Demande le nombre maximal d'allumettes à brûler par coup.
 * Rappel : par défaut le nombre sera 3 si le chiffre est invalide (inférieur à 1).
 * @return Nombre maximal d'allumettes à brûler par coup.
 */
	public static int askMaxToBurn()
	{
		Scanner 		sc;
		boolean			btest;
		int 			i;

		System.out.println("(Tout chiffre inférieur à 1 sera remplacé par 3.)");
		System.out.print("Merci d'entrer le nombre maximal d'allumettes à brûler par tour : ");
		sc = new Scanner(System.in);
		btest = false;
		i = 0;
		do 
		{
			try 
			{
				i = sc.nextInt();
				btest = true;
			}
			catch (java.util.InputMismatchException e)
			{
				System.out.println("Merci d'entrer un chiffre de type Integer.");
				btest = false;
				String purge = sc.next();
			}
		} while (btest == false);
		return(i);
	}
}
