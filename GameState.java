/**
 * Status of the game
 */
class GameState
{
	private	boolean			state;
	private	int		 		nbMove;
	private int 			boardSize;
	private static int 		maxToBurn;

	/**
	 * Initialise un nouveau jeu.
	 * @param  nbLine int renvoyé par console.getsize()
	 */
	public GameState()
	{
		this.state = true;
		this.nbMove = 0;
		this.boardSize = -1;
		this.maxToBurn = 3;
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

	public void setMaxToBurn(int n)
	{
		if (n < 1)
			n = 3;
		this.maxToBurn = n;
	}

/**
 * Accesseur du nombre de coups joues.
 */
	public int getNbMove()
	{
		return (this.nbMove);
	}

/**
 * Accesseur du nombre maximal d'allumettes à bruler
 * @return [description]
 */
	public static int getMaxToBurn()
	{
		return (maxToBurn);
	}
}