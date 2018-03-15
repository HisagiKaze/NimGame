import java.util.Scanner;
import java.util.StringTokenizer;

class Console
{
/**
 * Demande au joueur de saisir le nombre de lignes du plateau 
 * et retourne cet entier.
 * @return    Nombre de ligne du plateau.
 */
	public static int getSize()
	{
		int 	nb;

		nb = InputMismatchException(sc);
		return (nb);
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
		StringTokenizer	st;
		boolean			btest;
		int 			line;
		int 			match;

		System.out.println("C'est à " + name + " de jouer :");
		System.out.print("Entrez votre coup sous la forme \'m\' \'n\' où ");
		System.out.println("\'m\' est la ligne et \'n\' est le nombre d'allumettes.");

		sc = new Scanner(System.in);
		st = new StringTokenizer(sc.next(), " ");
		btest = false;
		do 
		{
			try 
			{
				line = Integer.parseInt(st.nextToken());
				match = Integer.parseInt(st.nextToken());
				btest = true;
			}
			catch (java.util.InputMismatchException e)
			{
				System.out.println("Merci d'entrer deux chiffres de type Integer séparés par un espace.");
				btest = false;
				String purge = sc.next();
			}
		} while (btest == false)
		sc.reset();
		Move.setLine(line - 1);
		Move.setMatch(match);
	}

/**
 * Affiche le plateau represente par le tableau d’entiers board où 
 * board[i] est le nombre d’allumettes restantes de la ligne i.
 * @param Board 	Nombre d'allumettes restantes sur la ligne i.
 */
	public static void ShowBoard(int[] Board)
	{}
/**
 * Affiche un message indiquant au joueur que son coup est invalide.
 * @param move Dernier coup jouer.
 */
	public static void invalidMove(Move move)
	{
		System.out.println("Le dernier coup est impossible :");
		System.out.println("Ligne du coup / Nombre de ligne maximum : " + (move.getLine + 1) + "/" + board.length);
		System.out.println("Nombre d'allumettes detruites / restantes : " + move.getMatch + "/" + board[move.getLine - 1]);
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
		boolean btest;
		Scanner sc;

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
}