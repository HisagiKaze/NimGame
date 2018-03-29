import java.util.*;
/**
 * Inteligence artificielle aleatoire contre joueur
 * @author N'GONDO Cédric
 **/
class IA_naive
{
    String  name;
    int     nbWin;
    String namePlayer;

    /**
     * Contructeur IA_naive
     * @init le nom et le nombre de partie gagnée
     */
    public IA_naive()
    {
    	this.name = "Bot";
    	this.nbWin = 0;
    }
    
    /**
     *Accesseur de l'attribut namePlayer
     *@return le  nom du Joueur
     */
    public String getNamePlayer()
    {
	   return this.namePlayer;
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
	   return this.nbWin++;
    }

    /**
     *Mutateur de l'attribut namePlayer
     *@param nP correspond au nom du joueur à afficher
     */
    public void setNamePlayer(String nP)
    {
	   this.namePlayer = nP;
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
    public void setNbWin(String w)
    {
	   this.name = w;
    }

    public static int ligneIa(int [] table)
    {
    	int i;
    	int size;
    	boolean cond;
    	boolean[] trueLine;

    	i = 0;
    	cond = false;
    	trueLine = new boolean [table.length];
    	size = trueLine.length;
    	while(i < table.length-1)
    	{
    	    if(table[i] >  0)
    		trueLine[i] = true;
    	    else
    		trueLine[i] = false;
    	    i++;
    	}
    	i = 0;
    	while(cond == false)
    	{
    	    i = ((int)Math.random() * (size));
    	    cond = trueLine[i];
    	}
    	return i;
    }

    /**
     * Méthode qui permet à l'IA de choisir la  ligne et le nombre d'allumette
     * @param board correspond au allumette
     * @return la ligne et le nombre d'allumette choisie par l'IA par l'objet Move
     */
    public Move ia_Choice(int [] table)
    {
    	Move move;
    	int randomLine;
    	int randomNbMatch;

    	randomNbMatch = 1;
        randomLine = ligneIa(table);
    	move = new Move( randomLine,1);
        return (move);
    }
}
