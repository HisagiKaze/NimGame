/**
 * Coup d'un joueur
 * Defini par une ligne et un nombre d'allumette
 * a detruire.
 * @author Paul-Aurian
 */
class Move
{
	private	int	line;
	private int	match_nb;

/**
 * Constructeur par defaut de l'objet Move.
 * (set both int to -1)
 */
	public Move()
	{
		this.line = -1;
		this.match_nb = -1;
	}

/**
 * Constructeur avec parametre de l'objet Move.
 * @param line     numero de la ligne du coup joue.
 * @param match_nb Nombre d'allumettes a supprimer
 */
	public Move(int line, int match_nb)
	{
		this.line = line;
		this.match_nb = match_nb;
	}

/**
 * Indique la ligne où est joué le coup.
 * @param x Numero de la ligne.
 */
	public void setLine(int x)
	{
		this.line = x;
	}

/**
 * Definie le nombre d'allumettes a retirer de la ligne.
 * @param x [description]
 */
	public void setMatchNb(int x)
	{
		this.match_nb = x;
	}

/**
 * Retourne la numero de la ligne jouer ce coup.
 * @return Numero de la ligne
 */
	public int getLine()
	{
		return (this.line);
	}

/**
 * Retourne le nombre d'allumettes à supprimer pour ce coup.
 * @return Nombre d'allumette à supprimer.
 */
	public int getMatchNb()
	{
		return (this.match_nb);
	}
}