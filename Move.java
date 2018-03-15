class Move
{
	private	int	line;
	private int	match_nb;

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