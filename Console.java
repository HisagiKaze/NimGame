class Console
{
/**
 * Demande au joueur de saisir le nombre de lignes du plateau 
 * et retourne cet entier.
 */
	public static int getSize()
	{}

/**
 * Demande au joueur de saisir un coup sous la forme ’m n’ ou ’m’ 
 * est la ligne et ’n’ est le nombre d’allumettes.
 * @param name	Nom du joueur courrant
 * @return Move 	Renvoie le coup jouer par le joueur
 */
	public static Move getMove(String name)
	{}

/**
 * Affiche le plateau represente par le tableau d’entiers board où 
 * board[i] est le nombre d’allumettes restantes de la ligne i.
 * @param Board 	Nombre d'allumettes restantes sur la ligne i.
 */
	public static void ShowBoard(int[] Board)
	{}
/**
 * Affiche un message indiquant au joueur que son coup est invalide.
 * @param move Dernier coup jouer.
 */
	public static void invalidMove(Move move)
	{}

/**
 * Affiche un message annoçant la victoire du joueur.
 * @param name Nom du joueur victorieux.
 */
	public static void showWinner(String name)
	{}
}