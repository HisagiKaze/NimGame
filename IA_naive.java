/**
 * Inteligence artificielle
 * @author N'GONDO Cédric
 **/
class IA_naive
{
    String  name;
    int     nbWin;

    /**
     * Contructeur IA_naive
     * @init le nom et le nombre de partie gagnée
     */
    public IA_naive( int w)
    {
    	this.name = "Bot_1";
    	this.nbWin = w++;
    }

    /**
     * Accesseur de l'attribut name
     * @return le nom de l'objet instancié
     */
    public String getname()
    {
	   return this.name;
    }

    /**
     * Mutateur de l'attribut name
     * @param n correspont au nom à afficher
     */
    public void setname(String n)
    {
	   this.name = n;
    }

    /**
     * Mutateur de l'attribut nbWin
     * @param n correspont au nombre de partie gagnée à afficher
     */
    public void setnbWin(String w)
    {
	   this.name = w;
    }

    /**
     * Tableau à 1 dimension correspondant aux choix de l'IA naïve
     * tab[0] correspond au numéro de ligne que l'IA naive choisie en fonction du nombre max de ligne
     * tab[1] correspond au nombre d'alummette choisie par l'IA allant 1 à 3
     * @param size indique le nombre max de ligne
     * @return le numéro de la ligne et le nombre de d'allumette
     */
    public static int[] ia_Choice(int size)
    {
    	int [] tab;
    	int i;

    	tab = new int [2];
    	i = 0;
    	while(i < tab.length - 1)
    	{
    	    tab[i++] = ((int)(Math.random() * (size - 1) - 0)*(size - 1));
    	    tab[i++] = ((int)(Math.random() * 3 - 1) * 3);
    	}
    	return (tab);
    }

    /**
     * Methode choix line
     * @param tab correspond au valeurs de la methode ia_Choice
     * @return le nombre de ligne que l'IA choisie
     */
    public static int move_Line(int[] tab)
    {
	   return (tab[0]);
    }

    /**
     * Methode choix line
     * @param tab correspond au valeurs de la methode ia_Choice
     * @return le nombre d'allumette que l'IA choisie
     */
    public static int move_nbMatch(int[] tab)
    {
	   return (tab[1]);
    }    
}
