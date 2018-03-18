/**
 * Objet HumanPlayer
 * name : Nom du joueur
 * nbWins : Nombre de victoire du joueur
 * next : Le joueur suivant
 *
 * @author Paul-Aurian
 */
class HumanPlayer
{
	private	String		name;
	private	int 		nbWins;
	private HumanPlayer next;

/**
 * Constructeur avec parametre.
 * @param name Nom du joueur.
 */
	public void HumanPlayer(String name)
	{
		this.name = name;
		this.nbWins = 0;
		this.next = null;
	}

/**
 * Mutateur pour redefinir le nom du joueur.
 * @param name Nouveau nom du joueur.
 */
	public void setName(String name)
	{
		this.name = name;
	}

/**
 * Mutateur pour incrementer le nombre de victoire du joueur.
 */
	public void setNbWins()
	{
		this.nbWins++;
	}

/**
 * Mutateur du joueur suivant
 * @param nextPlayer Autre joueur.
 */
	public void setNext(HumanPlayer nextPlayer)
	{
		this.next = nextPlayer;
	}

/**
 * Accesseur du nom du joueur.
 * @return nom du joueur.
 */
	public String getName()
	{
		return (this.name);
	}

/**
 * Acceusseur du nombre de victoire du joueur.
 * @return nombre de victoire.
 */
	public int getNbWins()
	{
		return (this.nbWins);
	}

/**
 * Accesseur du joueur suivant
 * @return adresse du joueur suivant
 */
	public HumanPlayer getNext()
	{
		return (this.next);
	}
}