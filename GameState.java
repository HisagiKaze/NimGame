class GameState
{
	private	boolean			state;
	private	int		 		nbMove;

	/**
	 * Initialise un nouveau jeu.
	 * @param  nbLine int renvoyé par console.getsize()
	 */
	public GameState(int nbLine)
	{
		this.state = true;
		this.nbMove = 0;
	}

	public static void setState(boolean state)
	{
		this.state = state;
	}
}