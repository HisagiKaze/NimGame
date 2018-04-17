/**
 * Appelle une a une toutes les fonctions pour jouer au Nim.
 * @author Cedric et Paul-Aurian
 * @version 3.1 Human VS Human
 */
class Nim
{
	public static void main(String[] args)
	{
		HumanPlayer 	player;
		GameState 		currentGame;
		boolean 		bPlayAgain;
		Board 			table;

		Console.script(0);//Greetings
		player = Console.getName(2);
		Console.script(1);//Size of the board
		bPlayAgain = true;
		while (bPlayAgain)
		{
			currentGame = new GameState();
			table = new Board();
			currentGame.setMaxToBurn(Console.askMaxToBurn());
			while (table.getNbMatchLeft() > 1)
			{
				Console.ShowBoard(table.getBoard());
				if (table.setBoard(Console.getMove(player.getName())))
				{
					currentGame.setNbMove();
					player = player.getNext();
					Console.clear_term();
				}
				Console.printNbMatchLeft(table.getNbMatchLeft());
			}
			if (table.getNbMatchLeft() > 0)
				Console.showWinner(player.getNext().getName());
			else
				Console.showWinner(player.getName());
			player.setNbWins();
			Console.nbMovePlayed(currentGame.getNbMove());
			currentGame.setState(false);
			bPlayAgain = Console.askToPlayAgain();
		}
		Console.printNbWins(player, player.getNext().getNbWins());
	}
}