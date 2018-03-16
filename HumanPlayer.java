class HumanPlayer
{
	private	String	name;
	private	int 	nbWins;

/**
 * Constructeur par defaut.
 */
	public HumanPlayer()
	{
		this.name = null;
		this.nbWins = 0;
	}

/**
 * Constructeur par avec name.
 * @param name [nom du joueur.
 */
	public HumanPlayer(String name)
	{
		this.name = name;
		this.nbWins = 0;
	}

/**
 * Redefinir le nom du joueur.
 * @param name Nouveau nom du joueur.
 */
	public static void setName(String name)
	{
		this.name = name;
	}

/**
 * Incrementer le nombre de victoire du joueur.
 */
	public static void setNbWins()
	{
		this.nbWins++;
	}

/**
 * Renvoie le nombre de victoire du joueur.
 * @return nombre de victoire.
 */
	public static int getNbWins()
	{
		return (this.nbWins);
	}
}