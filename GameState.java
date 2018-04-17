/**
 * Statut du jeu.
 * @author Cedric et Paul-Aurian
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

/**
 * Mutateur du nombre maximal d'allumettes à brûler.
 * @param n nombre renvoyé par Console.askMaxToBurn() via le main.
 */
	public void setMaxToBurn(int n)
	{
		if (n < 1)
			n = 3;
		this.maxToBurn = n;
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
}