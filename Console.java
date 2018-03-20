import java.util.Scanner;

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
		int 	boardSize;

		boardSize = InputMismatchException();
		return (boardSize);
	}

/**
 * Recupere le nom des joueurs.
 * @return Un tableau de deux joueurs.
 */
	public static HumanPlayer getName()
	{
		Scanner		sc;
		HumanPlayer player1;
		HumanPlayer player2;

		sc = new Scanner(System.in);
		player1 = new HumanPlayer(sc.next());
		player2 = new HumanPlayer(sc.next());
		player1.setNext(player2);
		player2.setNext(player1);
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
 * @param Board 	Nombre d'allumettes restantes sur la ligne i.
 */
	public static void ShowBoard(int[] board)
    {
	    int i;
	    int size;
	    int space;
	    int compt;

	    i = 0;
	    size = board.length - 1;
	    compt = 0;
	    while(i < size)
	    {
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
			i++;
	    }
    }
/**
 * Affiche un message indiquant au joueur que son coup est invalide.
 * @param move Dernier coup jouer.
 */
	public static void invalidMove(Move move)
	{
		System.out.println("Le dernier coup est impossible :");
		//System.out.println("Ligne du coup / Nombre de ligne maximum : " + (move.getLine() + 1) + "/" + Board.getBoard().length);
		//System.out.println("Nombre d'allumettes detruites / restantes : " + move.getMatchNb() + "/" + Board.getBoard()[Move.getLine() - 1]);
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
	public static void clear_term () {

		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

/**
 * InputMismatchException checks if the user enter 
 * an INTEGER and not something else instead.
 * @return   Forcement un INT
 */
	static int InputMismatchException () {

		int		x;
		boolean	btest;
		Scanner	sc;

		x = 0;
		btest = false;
		sc = new Scanner(System.in);
		do 
		{
			try 
			{
				System.out.print("Entrez un nombre : ");
				x = sc.nextInt();
				btest = true;
			}
			catch (java.util.InputMismatchException e) 
			{
				System.out.println("Merci d'entrer un chiffre de type Integer.");
				btest = false;
				String purge = sc.next();
			}
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
		{
			System.out.println("Bonjour et bienvenue dans le jeu du Nim");
			System.out.println("Merci d'entrer le nom des deux joueurs :");
		}
		else if (i == 1)
			System.out.println("Merci. Maintenant veuillez entrer la taille de plateau souhaitee : ");
		else if (i == 2)
			System.out.println("Voici donc votre plateau de jeu :");
		//else if (i == 3)
	}
}
