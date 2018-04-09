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
        ArrayList<Move>     choiceList;
        Move                iaMove;
        int                 i;
        int                 j;

        choiceList = new ArrayList<Move>();
        i = -1;
        while (++i < board.getBoard().length)           // On parcourt le plateau
        {
            j = 0;
            if (board.getBoard()[i] > 0)                //Si une ligne du plateau n'est pas vide
                while ((j < board.getBoard()[i]) && (j < 3))    //Tant que 'j' est inférieur (au nb d'allumettes sur la ligne i) et à 3
                    choiceList.add(new Move(i, ++j));   //On ajoute un choix possible à la choiceList
        }
        if (level == 0)
        	iaMove = iaChoiceNaive(choiceList);
        else
        	iaMove = iaChoiceSmart(choiceList, board);
        if (board.setBoard(iaMove))                     //Si le move est correct
            Console.explainIaMove(iaMove);
        return (board.getNbMatchLeft() == 1);           // S'il ne reste qu'une allumette sur le plateau, l'IA a gagnée.
    }

/**
 * Permet de faire un choix aléatoire dans la liste des coups possible.
 * @param choiceListe Liste des coups possibles
 * @return       Le coup à jouer
 */
    private Move iaChoiceNaive(ArrayList<Move> choiceList)
    {
        Random  nb;// Random est une alternative à Math.random apparemment bien plus efficace

        nb = new Random();//nb.nextInt((max - min) + 1) + min (pour exclure 0)
        return (choiceList.get(nb.nextInt((choiceList.size() - 1) + 1) + 1));
    }
/**
 * l'IA tente de jouer un coup permettant de revenir sur un noyau ((NbMatchLeft % 3) = 0)
 * Si elle ne peut pas le faire, elle joue un coup d'attente (aléatoire).
 * @param  choiceList Liste des coups possibles
 * @param  board      Plateau de jeu en cours
 * @return            Coup jouer.
 */
    private Move iaChoiceSmart(ArrayList<Move> choiceList, ArrayList<Integer> nodesList, Board board)
    {
    	int 	nbMatchLeft;

    	nbMatchLeft = board.nbMatchLeft();
    	while (i < choiceList.)
    }

    private ArrayList foundNode(ArrayList<Move> choiceList, Board board)
    {
    	ArrayList<Integer> 	nodesList;
    	int i;

    	nodesList = new ArrayList<Integer>();
    	i = 1;
    	while (i < board.getNbMatchLeft())
    	{
    		nodesList.add(i);
    		i = i + 4;
    	}
    	return (nodesList);
    }
}