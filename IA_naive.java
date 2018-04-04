/**
 * Inteligence artificielle aleatoire contre un joueur
 * @author POINOT Paul-Aurian
 **/
class IA_naive
{
    private int     nbWins;

    public IA_naive()
    {
        this.nbWins = 0;
    }

    public void setNbWins()
    {
        this.nbWins++;
    }

    public int getNbWins()
    {
        return (nbWins);
    }

    public boolean iaPlays(Board board)
    {
        Move    iaMove;
        int     i;
        int     n;

        iaMove = new Move();
        i = -1;
        while (++i < board.getBoard().length)        // On parcourt le plateau
        {
            if (board.getBoard()[i] > 0)               // Si une ligne n'est pas vide
            {
                iaMove.setLine(i);
                iaMove.setMatchNb(iaMatchesChoice(board.getBoard(), i));
                break;
            }
        }
        if (board.setBoard(iaMove))
            Console.explainIaMove(iaMove);
        return (board.getNbMatchLeft() == 1); // S'il ne reste qu'une allumette sur le plateau, l'IA a gagnée.
    }

    private int iaMatchesChoice(int [] board, int line)
    {
        if (board[line] > 3)
            return ((int)Math.random() * ((3 - 1) + 1) + 1); // (int)Math.random() * ((max - min) + 1)) + min;
        else if (board[line] == 3)
            return ((int)Math.random() * ((2 - 1) + 1) + 1);
        else
            return (1);
    }
}
