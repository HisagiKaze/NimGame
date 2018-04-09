import java.util.Random;
import java.util.ArrayList;
/**
 * Inteligence artificielle aleatoire contre joueur
 * @author N'GONDO Cédric
 **/
class IA_naive
{

/**
 * Accesseur de l'attribut nbWin
 * @return le nombre de parties gangné de l'objet instancié
 */
    public int getNbWin()
    {
	   return this.nbWin;
	}

/**
 * Mutateur de l'attribut nbWin
 * @param n correspond au nombre de partie gagnée à afficher
 */
    public void setNbWins()
    {
		this.nbWin++;
    }

    public boolean iaPlays(int [] table)
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
        iaMove = iaChoice(ChoiceList);
        if (board.setBoard(iaMove))                     //Si le move est correct
            Console.explainIaMove(iaMove);
        return (board.getNbMatchLeft() == 1);           // S'il ne reste qu'une allumette sur le plateau, l'IA a gagnée.
    }

/**
 * Permet de faire un choix aléatoire dans la liste des coups possible.
 * @param ChoiceListe Liste des coups possibles
 * @return       Le coup à jouer
 */
    private Move iaChoice(ArrayList<Move> ChoiceList)
    {
        Random  nb;// Random est une alternative à Math.random apparemment bien plus efficace

        nb = new Random();//nb.nextInt((max - min) + 1) + min (pour exclure 0)
        return (ChoiceList.get(nb.nextInt((ChoiceList.size() - 1) + 1) + 1));
    }
}
