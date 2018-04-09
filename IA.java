import java.util.Random;
import java.util.ArrayList;

/**
 * Inteligence artificielle aleatoire contre un joueur
 * @author POINOT Paul-Aurian
 **/
class IA
{
    private int     nbWins;

/**
 * Constructeur
 * @return rien
 */
    public IA()
    {
        this.nbWins = 0;
    }

/**
 * Mutateur qui incremente le nombre de victoire de l'IA naive
 */
    public void setNbWins()
    {
        this.nbWins++;
    }

/**
 * Accesseur du nombre de victoire de l'IA naive
 * @return Nombre de victoire
 */
    public int getNbWins()
    {
        return (nbWins);
    }

/**
 * Joue un coup et vérifie s'il à gagné.
 * @param  board Plateau de jeu
 * @return       Vrai si l'IA a gagnée, faux sinon.
 */
    public boolean iaPlays(Board board, int level)
    {
        ArrayList<Move>     ChoiceList;
        Move                iaMove;
        int                 i;
        int                 j;

        ChoiceList = new ArrayList<Move>();
        i = -1;
        while (++i < board.getBoard().length)           // On parcourt le plateau
        {
            j = 0;
            if (board.getBoard()[i] > 0)                //Si une ligne du plateau n'est pas vide
                while ((j < board.getBoard()[i]) && (j < 3))    //Tant que 'j' est inférieur (au nb d'allumettes sur la ligne i) et à 3
                    ChoiceList.add(new Move(i, ++j));   //On ajoute un choix possible à la ChoiceList
        }
        if (level == 0)
        	iaMove = iaChoiceNaive(ChoiceList);
        else
        	iaMove = iaChoiceSmart(ChoiceList, board);
        if (board.setBoard(iaMove))                     //Si le move est correct
            Console.explainIaMove(iaMove);
        return (board.getNbMatchLeft() == 1);           // S'il ne reste qu'une allumette sur le plateau, l'IA a gagnée.
    }

/**
 * Permet de faire un choix aléatoire dans la liste des coups possible.
 * @param ChoiceListe Liste des coups possibles
 * @return       Le coup à jouer
 */
    private Move iaChoiceNaive(ArrayList<Move> ChoiceList)
    {
        Random  nb;// Random est une alternative à Math.random apparemment bien plus efficace

        nb = new Random();//nb.nextInt((max - min) + 1) + min (pour exclure 0)
        return (ChoiceList.get(nb.nextInt((ChoiceList.size() - 1) + 1) + 1));
    }

/**
 * l'IA tente de jouer un coup permettant de revenir sur un noyau ((NbMatchLeft % 3) = 0)
 * Si elle ne peut pas le faire, elle joue un coup d'attente (aléatoire).
 * @param  ChoiceList Liste des coups possibles
 * @param  board      Plateau de jeu en cours
 * @return            Coup jouer.
 */
    private Move iaChoiceSmart(ArrayList<Move> ChoiceList, Board board)
    {
    	boolean 	btest;//Sert à vérifier si le coup existe bel et bien.
    	int 		NbMatchLeft;
    	int 		x;//Nombre d'allumettes a detruire pour atteindre le prochain noyau.
    	int 		i;

    	NbMatchLeft = board.getNbMatchLeft();//Pour éviter les futurs appels de fonction.
    	i = -1;
    	btest = false;
    	if (NbMatchLeft > 3)
    	{
	    	if ((NbMatchLeft % 3) == 0) //S'il est sur un noyau.
	    	{
	    		while (++i < ChoiceList.size())
	    		{
	    			if (ChoiceList.get(i).getMatchNb() == 3)
	    			{
	    				btest = true;
	    				break;
	    			}
	    		}
	    		if (!btest)
	    			return (iaChoiceNaive(ChoiceList));
	    		return(ChoiceList.get(i));
	    	}
	    	else if ((NbMatchLeft % 3) != 0) //S'il n'est pas sur un noyeau.
	    	{
	    		x = 2;
	    		if (((NbMatchLeft - 1) % 3) == 0)
	    			x = 1;
	    		while (++i < ChoiceList.size() - 1)
	    		{
	    			if (ChoiceList.get(i).getMatchNb() == x)
	    			{
	    				btest = true;
	    				break;
	    			}
	    		}
	    		if (!btest)
		    		while (++i < ChoiceList.size() - 1)
		    			if (ChoiceList.get(i).getMatchNb() == 1)
		    				return (ChoiceList.get(i));
		    	return (ChoiceList.get(i));
	    	}
	    }
	    else if (NbMatchLeft <= 3)
	    {
	    	x = 2;
	    	if (NbMatchLeft == 2)
	    		x = 1;
	    	while (++i < ChoiceList.size() - 1)
	    	{
	    		if (ChoiceList.get(i).getMatchNb() == x)
	    		{
	    				btest = true;
	    				break;
	    		}
	    	}
	    	if (!btest)
		    	while (++i < ChoiceList.size() - 1)
		    		if (ChoiceList.get(i).getMatchNb() == 1)
		    			return (ChoiceList.get(i));
		    return (ChoiceList.get(i));
	    }
	    return(iaChoiceNaive(ChoiceList)); //S'il y a un bug dans la matrice ...
    }
}