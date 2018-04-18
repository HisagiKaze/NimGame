import java.util.Random;
import java.util.ArrayList;

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
 * Utilise iaChoiceNaive().
 * @param  board Plateau de jeu
 * @return       Vrai si l'IA a gagnée, faux sinon.
 */
    public boolean iaPlays(Board board)
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
                while ((j < board.getBoard()[i]) && (j < GameState.getMaxToBurn()))    //Tant que 'j' est inférieur (au nb d'allumettes sur la ligne i) et à au nombre maximal d'allumettes à brûler
                    choiceList.add(new Move(i, ++j));   //On ajoute un choix possible à la choiceList
        }
        iaMove = iaChoiceNaive(choiceList);
        if (board.setBoard(iaMove))                     //Si le move est correct
            Console.explainIaMove(iaMove);
        return (board.getNbMatchLeft() == 1);           // S'il ne reste qu'une allumette sur le plateau, l'IA a gagnée.
    }

/**
 * Permet de faire un choix aléatoire dans la liste des coups possible.
 * @param choiceList Liste des coups possibles
 * @return       Le coup à jouer
 */
    private Move iaChoiceNaive(ArrayList<Move> choiceList)
    {
        Random              nb;// Random est une alternative à Math.random apparemment bien plus efficace

        nb = new Random();//nb.nextInt((max - min) + 1)
        return (choiceList.get(nb.nextInt((choiceList.size() - 1) + 1)));
    }
}