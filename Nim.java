/**
 * Appelle une a une toutes les fonctions pour jouer au Nim.
 * @author Paul-Aurian
 * @version 3.1 Human VS Human
 */
class Nim
{
	public static void main(String[] args) 
	{
		HumanPlayer []	player;
		Board			table;
		int				i;

		Console.script(0);
		player = Console.getName();
		Console.script(1);
		table = new Board();
		Console.clear_term();
		i = 0;
		while (table.getNbMatch() > 1)
		{
			Console.script(2);
			Console.ShowBoard(table.getBoard());
			if (i > 1)
				i = 0;
			if (table.setBoard(Console.getMove(player[i++].getName())) == false)
				i--;
		}
	}
}