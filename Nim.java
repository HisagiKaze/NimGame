/**
 * Appelle une a une toutes les fonctions pour jouer au Nim.
 * @author Cedric et Paul-Aurian
 * @version 3.3 Human VS IA Smart
 */
class Nim
{
	public static void main(String[] args)
	{
		HumanPlayer 	player;
		GameState 		currentGame;
		boolean 		bPlayAgain;
		boolean 		bIAWin;
		Board 			table;
		int 			level;
		IA 				ia;

		Console.clear_term();
		Console.script(0);//Greetings
		level = Console.askAnIA();
		ia = new IA();
		bIAWin = false;
		player = Console.getName((level < 0) ? 2 : 1);
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
					if ((level > -1) && (table.getNbMatchLeft() > 1))
					{
						bIAWin = ia.iaPlays(table, level);
						currentGame.setNbMove();
					}
					else if (level < 0)
					{
						player = player.getNext();
						Console.clear_term();
					}
				}
				Console.printNbMatchLeft(table.getNbMatchLeft());
				if (bIAWin || ((table.getNbMatchLeft() < 1) && (level >= 0)))
				{
					bIAWin = true;
					Console.script(2);//Donne l'information que l'ia a gagné
					ia.setNbWins();
				}
			}
			if (!bIAWin)
			{
				if (level < 0 && table.getNbMatchLeft() > 0)
					Console.showWinner(player.getNext().getName());
				else
					Console.showWinner(player.getName());
				player.setNbWins();
			}
			Console.nbMovePlayed(currentGame.getNbMove());
			currentGame.setState(false);
			bPlayAgain = Console.askToPlayAgain();
		}
		Console.printNbWins(player, (level < 0) ? (player.getNext().getNbWins()) : (ia.getNbWins()));
	}
}