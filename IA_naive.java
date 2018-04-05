/**
 * Inteligence artificielle aleatoire contre joueur
 * @author N'GONDO Cédric
 **/
class IA_naive
{
    String  name;
    int     nbWin;
    int 	nbLigne;
    int 	nbMatch;

/**
 * Contructeur IA_naive
 * @init le nom et le nombre de partie gagnée
 */
    public IA_naive()
    {
    	this.name = "Bot";
    	this.nbWin = 0;
		this.nbLigne = 0;
		this.nbMatch = 0;
    }

/**
 * Accesseur de l'attribut name
 * @return le nom de de l'IA
 */
    public String getName()
    {
	   return this.name;
    }

/**
 * Accesseur de l'attribut nbWin
 * @return le nombre de parties gangné de l'objet instancié
 */
    public int getNbWin()
    {
	   return this.nbWin;
    }
    
    public int getNbLigne()
    {
		return (this.nbLigne);
    }

    public int getNbMatch()
    {
		return (this.nbMatch);
    }

/**
 * Mutateur de l'attribut name
 * @param n correspond au nom à afficher
 */
    public void setName(String n)
    {
	   this.name = n;
    }

/**
 * Mutateur de l'attribut nbWin
 * @param n correspond au nombre de partie gagnée à afficher
 */
    public void setNbWins()
    {
		this.nbWin++;
    }

    public void setNbLigne(int l)
    {
		this.nbLigne = l;
    }

    public void setNbMatch(int m)
    {
		this.nbMatch = m;
    }

    public int ligneIa(int [] table)
    {
		int [] 	sLine;
		int 	i;
		int 	line;
		boolean quest;

		sLine = new int [table.length];
		i = -1;
		line = 0;
		quest = false;
		while(++i < table.length)
		{
		    if(table[i] > 0)
				sLine[i] = i;
		    else
				sLine[i] = -1;
		}
		i = -1;
		while (++i < sLine.length)
		    System.out.println(sLine[i]);
		while (!quest)
		{
		    line = ((int)(Math.random() * (sLine.length)));
		    if(sLine[line] == -1)
				quest = false;
		    else
				quest = true;
		}
		System.out.println(line);
		return (line);
    }

    public int nBmatchIa(int[] table, int ligne)
    {
		int max;
		int random;

		max = 0;
		if(table[ligne] > 3)
		    max = 3;
		else if(table[ligne] > 0 && table[ligne] < 3)
		    max = table[ligne];
		random = (int)(Math.random() * (max - 1) + 1);
		return (random);
    }

/**
 * Méthode qui permet à l'IA de choisir la  ligne et le nombre d'allumette 
 * @param board correspond au allumette
 * @return la ligne et le nombre d'allumette choisie par l'IA par l'objet Move
 */
    public Move ia_Choice(int [] table)
    {
		Move move;

	    move = new Move();
		move.setLine(ligneIa(table));
		move.setMatchNb(nBmatchIa(table, move.getLine()));
	    return (move);
    }

    public boolean iaPlays(int [] table)
    {
		int i;
		int compt;
		int compt2;

		i = -1;
		compt = 0;
		compt2 = 0;
		while(++i < table.length - 1)
		{
		    if(table[i] > 1)
				compt++;
		    if(table[i] == 1)
				compt2++;
		}
		if(compt == 0 && compt2 == 1)
		    return (true);
		return (false);
    }
}
