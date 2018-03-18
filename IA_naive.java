/**
 * Inteligence artificielle aleatoire
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
    public IA_naive(int w)
    {
    	this.name = "Bot";
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
    public Move ia_Choice(int [] board])
    {
    	Move   move;
    	int    i;

        i = 0;
    	while (i == 0)
        {
            move = new Move((int)Math.random() * (board.length()), (int)Math.random() * (4 - 1) + 1);
            if (setBoard(move) == false)
                ia_Choice(board);
        }
    	return (move);
    }

/**
 * Verifie si le move est valide, et si oui, il l'effectue.
 * Sinon il utilise Console.invalidMove(move).
 * @param  move Un coup possedant une ligne et un nombre d'allumettes.
 * @return      Vrai si le move a été effectué, faux sinon.
 */
    public boolean setBoard(Move move)
    {
        if (this.board[move.getLine()] >= move.getMatchNb())
        {
            this.board[move.getLine()] = this.board[move.getLine()] - move.getMatchNb();
            this.nbMatchLeft = this.nbMatchLeft - move.getMatchNb();
            return (true);
        }
        else
            Console.invalidMove(move);
        return (false);
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
