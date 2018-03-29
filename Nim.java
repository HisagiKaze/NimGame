/**
 * Appelle une a une toutes les fonctions pour jouer au Nim.
 * @author Paul-Aurian
 * @version 3.1 Human VS Human
 */
class Nim
{
	public static void main(String[] args) 
	{
		GameState 		currentGame;
		HumanPlayer		currentPlayer;
		boolean			bWantToPlayAgain;
		Board			table;
		int				i;

		Console.script(0);
		currentPlayer = Console.getName();
		Console.script(1);
		bWantToPlayAgain = true;
		while (bWantToPlayAgain)
		{
			currentGame = new GameState();
			table = new Board();
			i = 0;
			Console.clear_term();
			while (table.getNbMatchLeft() > 1)
			{
				Console.ShowBoard(table.getBoard());
				if (table.setBoard(Console.getMove(currentPlayer.getName())))
				{
					currentGame.setNbMove();
					currentPlayer = currentPlayer.getNext();
				}
				Console.clear_term();
				Console.printNbMatchLeft(table.getNbMatchLeft());
			}
			if (table.getNbMatchLeft() < 1)
				Console.showWinner(currentPlayer.getName());
			else
				Console.showWinner(currentPlayer.getNext().getName());
			Console.nbMovePlayed(currentGame.getNbMove());
			currentGame.setState(false);
			bWantToPlayAgain = Console.askToPlayAgain();
		}
	}
}