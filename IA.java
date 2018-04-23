import java.util.Random;

/**
 * Inteligence artificielle aleatoire contre un joueur
 * @author POINOT Paul-Aurian
 **/
class IA
{
    /**
     * nbWins : Nombre de victoire de l'IA.
     */
    private int             nbWins;

/**
 * Constructeur
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
 * Joue un coup et vérifie s'il a gagné.
 * Utilise iaChoiceNaive() et/ou iaChoiceSmart()
 * @param  board Plateau de jeu
 * @param level niveau de l'IA (0 facile/naive et 1 difficile/smart)
 * @return       Vrai si l'IA a gagnée, faux sinon.
 */
    public boolean iaPlays(Board board, int level)
    {
        FT_ArrayList<Move>     choiceList;
        Move                iaMove;
        int                 i;
        int                 j;

        choiceList = new FT_ArrayList<Move>();
        i = -1;
        while (++i < board.getBoard().length)           // On parcourt le plateau
        {
            j = 0;
            if (board.getBoard()[i] > 0)                //Si une ligne du plateau n'est pas vide
                while ((j < board.getBoard()[i]) && (j < GameState.getMaxToBurn()))    //Tant que 'j' est inférieur (au nb d'allumettes sur la ligne i) et à au nombre maximal d'allumettes à brûler
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
 * @param choiceList Liste des coups possibles
 * @return       Le coup à jouer
 */
    private Move iaChoiceNaive(FT_ArrayList<Move> choiceList)
    {
        Random                  nb;// Random est une alternative à Math.random apparemment bien plus efficace

        nb = new Random();//nb.nextInt((max - min) + 1)
        return (choiceList.get(nb.nextInt((choiceList.size() - 1) + 1)));
    }
/**
 * l'IA tente de jouer un coup permettant de revenir sur un noyau "perdant"
 * Si elle ne peut pas le faire, elle joue un coup d'attente (aléatoire).
 * @param  choiceList Liste des coups possibles
 * @param  board      Plateau de jeu en cours
 * @return            Coup jouer.
 */
    private Move iaChoiceSmart(FT_ArrayList<Move> choiceList, Board board)
    {
    	int                    i;
    	FT_ArrayList<Node>     highNodesList;

    	i = -1;
    	highNodesList = foundNode(choiceList, board);
    	if (!highNodesList.isEmpty())
    		while (++i < choiceList.size() - 1)// On parcourt la liste de coups, si on peut atteindre le noyau suivant, on joue le coup.
    			if (choiceList.get(i).getMatchNb() == (board.getNbMatchLeft() - (highNodesList.get(highNodesList.size() - 1).getValue())))
    				return (choiceList.get(i));
    	return (iaChoiceNaive(choiceList));// Sinon, on joue un coup d'attente aléatoire
    }

/**
 * Permet de faire la liste des noeuds du tableau passé en paramètre.
 * La fonction crée un tableau de taille [nbMatchLeft][MaxMatchToBurn]
 * et cherche tous les noeuds (1, puis tous ce ne contenant pas le dernier noeud)
 * et renvoie finalement une liste contenant ces noeuds.
 * @param  choiceList Liste des coups possibles
 * @param  board      Plateau de jeu
 * @return            Liste des noeuds "perdant".
 */
    private FT_ArrayList<Node> foundNode(FT_ArrayList<Move> choiceList, Board board)
    {
    	FT_ArrayList<Node>     nodesList;
        FT_ArrayList<Node>     highNodes;
        int                    i;
        int                    j;
        int                    k;

        nodesList = new FT_ArrayList<Node>();
        i = 0;
        while (++i < board.getNbMatchLeft() - 1)
        {
            j = i - 1;
            k = 0;
            nodesList.add(new Node(i));
            while (--j >= 0 && ++k <= GameState.getMaxToBurn())
                nodesList.get(j).createParent(nodesList.get(i - 1));
            j = i - 1;
            k = 0;
            while (j > 0 && k++ < GameState.getMaxToBurn())
                nodesList.get(i - 1).createSuccessor(nodesList.get(--j));
        }
        highNodes = new FT_ArrayList<Node>();
        i = 0;
        highNodes.add(nodesList.get(i));
        while (++i < nodesList.size() - 1)
            if (nodesList.get(i).getSuccessors().doesNotHave(highNodes.get(highNodes.size() - 1)))
                highNodes.add(nodesList.get(i));
        return (highNodes);
    }
}







