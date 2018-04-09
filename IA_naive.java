import java.util.Random;
import java.util.ArrayList;

/**
 * Inteligence artificielle aleatoire contre un joueur
 * @author POINOT Paul-Aurian
 **/
class IA_naive
{
    private int     nbWins;

/**
 * Constructeur
 * @return rien
 */
    public IA_naive()
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
    public boolean iaPlays(Board board)
    {
        ArrayList   ChoiceList;
        Move        iaMove;
        int         i;

        ChoiceList = new ArrayList();
        i = -1;
        while (++i < board.getBoard().length)           // On parcourt le plateau
        {
            if (board.getBoard()[i] > 0)                // Si une ligne n'est pas vide
            {
                iaMove.setLine(i);
                for (int j = 0; (j < board.getBoard()[i]) && (j < 3); j++) //On ajoute un choix possible à la ChoiceList
                {
                    iaMove.setMatchNb(j + 1);
                    ChoiceList.add(iaMove);
                }
            }
        }
        iaMove = iaChoice(ChoiceList);
        if (board.setBoard(iaMove))
            Console.explainIaMove(iaMove);
        return (board.getNbMatchLeft() == 1);           // S'il ne reste qu'une allumette sur le plateau, l'IA a gagnée.
    }

/**
 * Permet de faire un choix aléatoire dans la liste des coups possible.
 * @param ChoiceListe Liste des coups possibles
 * @return       Le coup à jouer
 */
    private Move iaChoice(ArrayList ChoiceList)
    {
        Random  nb;                                      // Random est une alternative à Math.random apparemment bien plus efficace

        nb = new Random();                               //nb.nextInt() * ((max - min) + 1)) + min; Rappel du fonctionnement.
        nb = nb.nextInt() * ((ChoiceList.size() - 1) + 1) + 1; //Defini nb comme l'index aléatoire entre la fin et le début de la liste.
        return (ChoiceList.get(nb));                     // Retrourne le Move à l'index aléatoire "nb"
    }
}
