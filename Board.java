/**
 * Gestion du plateau d'allumettes
 * @author POINOT Paul-aurian
 */
class Board
{
	private int []	board;
	private int		nbMatchLeft;

/**
 * Initialise le tableau d'allumettes.
 */
	public Board()
	{
		int		size;
		int		i;

		size = Console.getSize();
		this.board = new int [size];
		i = 0;
		while (i < this.board.length - 1)
			this.board[i++] = 2 * i + 1;
		this.nbMatchLeft = (size * size);
	}

/**
 * Verifie si le move est valide, et si oui, il l'effectue.
 * Sinon il utilise Console.invalidMove(move).
 * @param  move Un coup possedant une ligne et un nombre d'allumettes.
 * @return      Vrai si le move a été effectué, faux sinon.
 */
	public static boolean setBoard(Move move)
	{
		if (this.board[move.line] >= move.match_nb)
		{
			this.board[move.line] = this.board[move.line] - move.match_nb;
			this.nbMatchLeft = this.nbMatchLeft - move.match_nb;
			return (true);
		}
		else
			Console.invalidMove(move);
		return (false);
	}

/**
 * Renvoie le tableau d'allumettes
 * @return Tableau d'allumettes
 */
	public static int [] getBoard()
	{
		return (this.board);
	}

/**
 * Renvoie le nombre d'allumettes restantes sur le plateau.
 * @return Nombre d'allumettes restantes.
 */
	public static int getNbMatch()
	{
		return (this.nbMatchLeft);
	}
}