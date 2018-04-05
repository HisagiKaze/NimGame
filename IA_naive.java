import java.util.Random;

/**
 * Inteligence artificielle aleatoire contre un joueur
 * @author N'Gondo Cedric
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
        Move    iaMove;
        int     i;
        int     n;

        iaMove = new Move();
        i = -1;
        while (++i < board.getBoard().length)           // On parcourt le plateau
        {
            if (board.getBoard()[i] > 0)                // Si une ligne n'est pas vide
            {
                iaMove.setLine(i);
                iaMove.setMatchNb(iaMatchesChoice(board.getBoard(), i));
                break;
            }
        }
        if (board.setBoard(iaMove))
            Console.explainIaMove(iaMove);
        return (board.getNbMatchLeft() == 1);           // S'il ne reste qu'une allumette sur le plateau, l'IA a gagnée.
    }

/**
 * Permet de faire un choix aléatoire d'allumettes suivant le nombre qu'il en reste sur la ligne choisi.
 * @param  board tableau du plateau de jeu
 * @param  line  Ligne du coup choisi
 * @return       Nombre d'allumette à détruire pour ce coup.
 */
    private int iaMatchesChoice(int [] board, int line)
    {
        Random nb;                                      // Random est une alternative à Math.random apparemment bien plus efficace

        nb = new Random();
        if (board[line] > 3)
            return (nb.nextInt(3 - 1 + 1) + 1);         // nb.nextInt() * ((max - min) + 1)) + min;
        else if (board[line] == 3)
            return (nb.nextInt(2 - 1 + 1) +1);
        else
            return (1);
    }
}
