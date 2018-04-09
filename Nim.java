/**
 * Appelle une a une toutes les fonctions pour jouer au Nim.
 * @author Paul-Aurian
 * @version 3.2 Human VS IA Naïve
 */
class Nim
{
	/**
	 * Appelle toutes les fonctions filles du jeu si une IA est demandée
	 * @param level niveau de l'intelligence artificielle (-1, 0 ou 1).
	 */
	public static void main_IA(int level)
	{
		GameState 	currentGame;
		HumanPlayer	player;
		boolean		bWantToPlayAgain;
		boolean		bIAWin;
		Board 		table;
		IA 		 	artInte; 		// Artificial Inteligence

		Console.script(0); 			// Greetings & getName
		player = Console.getName(1);
		artInte = new IA();
		Console.script(1); 			// table size
		bWantToPlayAgain = true;
		bIAWin = false;
		while (bWantToPlayAgain)
		{
			currentGame = new GameState();
			table = new Board();
			while (table.getNbMatchLeft() > 1)
			{
				Console.ShowBoard(table.getBoard());
				if (table.setBoard(Console.getMove(player.getName())))
				{
					currentGame.setNbMove();
					if (table.getNbMatchLeft() > 1)
					{
						bIAWin = artInte.iaPlays(table, level);
						currentGame.setNbMove();
					}
				}
				Console.printNbMatchLeft(table.getNbMatchLeft());
				if (bIAWin)
					break;
			}
			if (bIAWin)
			{
				Console.script(3); // IA a gagnée
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
		Console.printNbWins(player, artInte.getNbWins());
	}

	/**
	 * Appelle toutes les fonctions filles et gère le bon déroulement du jeu.
	 * @param args Arguments passés en parametre lors de l'appelle de la fonction.
	 */
	public static void main(String[] args) 
	{
		Console.clear_term();
		int i;

		i = Console.askAnIA(); 
		if (i >= 0)
			main_IA(i);
		else
		{
			HumanPlayer		currentPlayer;
			GameState 		currentGame;
			boolean			bWantToPlayAgain;
			Board			table;

			Console.script(0);
			currentPlayer = Console.getName(2);
			Console.script(1);
			bWantToPlayAgain = true;
			while (bWantToPlayAgain)
			{
				currentGame = new GameState();
				table = new Board();
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
			Console.printNbWins(currentPlayer, currentPlayer.getNext().getNbWins());
		}
	}
}