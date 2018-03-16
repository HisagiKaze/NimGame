import java.util.Scanner;
import java.util.StringTokenizer;

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
		int 	nb;

		nb = InputMismatchException();
		return (nb);
	}

	public static HumanPlayer getName()
	{
		HumanPlayer [] players;

		players = new HumanPlayer [2] ();
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
		Move 			currentMove;
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
		return (currentMove = new Move((line - 1), match));
	}

/**
 * Affiche le plateau represente par le tableau d’entiers board où 
 * board[i] est le nombre d’allumettes restantes de la ligne i.
 * @param Board 	Nombre d'allumettes restantes sur la ligne i.
 */
	public static void ShowBoard(int[] Board)
	{
		int i;
	    int j;
	    int size;
	    int pos;
	    int space;

	    i = 0;
	    j = 1;
	    size = this.getsize();
	    pos = 0;
	    while(i < size)
	    {
			space = 0;
			while(space++ < ((size - 1) - i))
		    	System.out.print(" ");
		    space = 0;
			while(space++ < (i + j))
			{
		    	if(Board[pos] == 1)
					System.out.print("|");
		    	else
					System.out.print(" ");
		    	if(pos < Board.length - 1)
					pos ++;
			}
			System.out.print("\n");
			j++;
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
}