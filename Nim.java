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
		Console.script(2);
		Console.ShowBoard(table.board);
		i = 0;
		while (table.nbMatchLeft > 1)
		{
			if (i > 1)
				i = 0;
			Console.getMove(player[i++])
		}
	}
}