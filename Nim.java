/**
 * Appelle une a une toutes les fonctions pour jouer au Nim.
 * @author Paul-Aurian
 * @version 3.1 Human VS Human
 */
class Nim
{
	public static void main(String[] args) 
	{
		HumanPlayer		currentPlayer;
		Board			table;
		int				i;

		Console.script(0);
		currentPlayer = Console.getName();
		Console.script(1);
		table = new Board();
		i = 0;
		Console.clear_term();
		while (table.getNbMatch() > 1)
		{
			Console.script(2);
			Console.ShowBoard(table.getBoard());
			if (table.setBoard(Console.getMove(currentPlayer.getName())))
				currentPlayer = currentPlayer.getNext();
			Console.clear_term();
		}
	}
}