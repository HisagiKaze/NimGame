class HumanPlayer
{
	private	String	name;
	private	int 	nbWins;

/**
 * Constructeur par defaut.
 */
	public void HumanPlayer()
	{
		this.name = null;
		this.nbWins = 0;
	}

/**
 * Constructeur avec parametre.
 * @param name Nom du joueur.
 */
	public void HumanPlayer(String name)
	{
		this.name = name;
	}

/**
 * Redefinir le nom du joueur.
 * @param name Nouveau nom du joueur.
 */
	public void setName(String name)
	{
		this.name = name;
	}

/**
 * Incrementer le nombre de victoire du joueur.
 */
	public void setNbWins()
	{
		this.nbWins++;
	}

/**
 * Renvoie le nom du joueur.
 * @return nom du joueur.
 */
	public String getName()
	{
		return (this.name);
	}

/**
 * Renvoie le nombre de victoire du joueur.
 * @return nombre de victoire.
 */
	public int getNbWins()
	{
		return (this.nbWins);
	}
}