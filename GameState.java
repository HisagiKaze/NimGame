/**
 * Status of the game
 */
class GameState
{
	private	boolean			state;
	private	int		 		nbMove;

	/**
	 * Initialise un nouveau jeu.
	 * @param  nbLine int renvoyé par console.getsize()
	 */
	public GameState()
	{
		this.state = true;
		this.nbMove = 0;
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
 * Accesseur du nombre de coups joues.
 */
	public int getNbMove()
	{
		return (this.nbMove);
	}
}