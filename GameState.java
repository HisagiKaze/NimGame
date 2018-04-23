/**
 * Statut du jeu.
 * @author Cedric et Paul-Aurian
 */
class GameState
{
	private	boolean			state;
	private	int		 		nbMove;
	private static int 		boardSize;
	private static int 		maxToBurn;

/**
 * Initialise un nouveau jeu.
 * @param  nbLine int renvoyé par console.getsize()
 */
	public GameState()
	{
		state = true;
		nbMove = 0;
		boardSize = -1;
		maxToBurn = 3;
	}

/**
 * Mutateur de l'etat du jeu.
 * @param state [Nouvel etat booeen du jeu]
 */
	public void setState(boolean state)
	{
		this.state = state;
	}

/**
 * Mutateur du nombre de coups joues
 * Incremente le nombre a chaque appel.
 */
	public void setNbMove()
	{
		this.nbMove++;
	}

/**
 * Mutateur du nombre maximal d'allumettes à brûler.
 * @param n nombre renvoyé par Console.askMaxToBurn() via le main.
 */
	public void setMaxToBurn(int n)
	{
		if (n < 1)
			n = 3;
		maxToBurn = n;
	}

	public static void setBoardSize(int n)
	{
		boardSize = n;
	}

/**
 * Accesseur du nombre de coups joués.
 */
	public int getNbMove()
	{
		return (this.nbMove);
	}

/**
 * Accesseur du nombre maximal d'allumettes à brûler
 * @return Nombre maximal d'allumettes à brûler.
 */
	public static int getMaxToBurn()
	{
		return (maxToBurn);
	}

	public static int getBoardSize()
	{
		return (boardSize);
	}
}