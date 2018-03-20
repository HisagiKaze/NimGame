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
		i = -1;
		while (i++ < this.board.length - 1)
		    this.board[i] = 2 * i + 1;
		this.nbMatchLeft = (size * size);
	}

/**
 * Verifie si le move est valide, et si oui, il l'effectue.
 * Sinon il utilise Console.invalidMove(move).
 * @param  move Un coup possedant une ligne et un nombre d'allumettes.
 * @return      Vrai si le move a été effectué, faux sinon.
 */
	public boolean setBoard(Move move)
	{
		if (this.board[move.getLine()] >= move.getMatchNb())
		{
			this.board[move.getLine()] = this.board[move.getLine()] - move.getMatchNb();
			this.nbMatchLeft = this.nbMatchLeft - move.getMatchNb();
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
	public int [] getBoard()
	{
		return (this.board);
	}

/**
 * Renvoie le nombre d'allumettes restantes sur le plateau.
 * @return Nombre d'allumettes restantes.
 */
	public int getNbMatch()
	{
		return (this.nbMatchLeft);
	}
}
