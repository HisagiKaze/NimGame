/**
 * Appelle une a une toutes les fonctions pour jouer au Nim.
 * @author Paul-Aurian
 * @version 3.1 Human VS Human
 */
class Nim
{
	/**
	 * Appelle toutes les fonctions filles du jeu si une IA est demandée
	 * @param void Le jeu ne requiert aucun parametre argument
	 */
	public static void main_IA()
	{
		GameState 	currentGame;
		HumanPlayer	player;
		IA_naive 	artInte; 		// Artificial Inteligence
		boolean		bWantToPlayAgain;
		boolean		bIAWin;
		Board 		table;
		int			i;

		Console.script(0); 			// Greetings & getName
		player = Console.getName(1);
		artInte = new IA_naive();
		Console.script(1); 			// table size
		bWantToPlayAgain = true;
		bIAWin = false;
		while (bWantToPlayAgain)
		{
			currentGame = new GameState();
			table = new Board();
			i = 0;
			while (table.getNbMatchLeft() > 1)
			{
				Console.ShowBoard(table.getBoard());
				if (table.setBoard(Console.getMove(player.getName())))
				{
					currentGame.setNbMove();
					if (table.getNbMatchLeft() > 1)
					{
						bIAWin = artInte.iaPlays(table);
						currentGame.setNbMove();
					}
				}
				Console.printNbMatchLeft(table.getNbMatchLeft());
				if (bIAWin)
					break;
			}
			if (bIAWin)
			{
				Console.script(3); 	// IA a gagnée
				artInte.setNbWins();
			}
			else
			{
				Console.showWinner(player.getName());
				player.setNbWins();
			}
			Console.nbMovePlayed(currentGame.getNbMove());
			currentGame.setState(false);
			bWantToPlayAgain = Console.askToPlayAgain();
		}
	}

	/**
	 * Appelle toutes les fonctions filles et gère le bon déroulement du jeu.
	 * @param args Arguments passés en parametre lors de l'appelle de la fonction.
	 */
	public static void main(String[] args) 
	{
		if (Console.askAnIA())
			main_IA();
		else
		{
			GameState 		currentGame;
			HumanPlayer		currentPlayer;
			boolean			bWantToPlayAgain;
			Board			table;
			int				i;

			Console.script(0);
			currentPlayer = Console.getName(2);
			Console.script(1);
			bWantToPlayAgain = true;
			while (bWantToPlayAgain)
			{
				currentGame = new GameState();
				table = new Board();
				i = 0;
				while (table.getNbMatchLeft() > 1)
				{
					Console.ShowBoard(table.getBoard());
					if (table.setBoard(Console.getMove(currentPlayer.getName())))
					{
						currentGame.setNbMove();
						currentPlayer = currentPlayer.getNext();
						Console.clear_term();
					}
					Console.printNbMatchLeft(table.getNbMatchLeft());
				}
				if (table.getNbMatchLeft() < 1)
					Console.showWinner(currentPlayer.getName());
				else
					Console.showWinner(currentPlayer.getNext().getName());
				currentPlayer.setNbWins();
				Console.nbMovePlayed(currentGame.getNbMove());
				currentGame.setState(false);
				bWantToPlayAgain = Console.askToPlayAgain();
			}
		}
	}
}