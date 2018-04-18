/**
 * Appelle une a une toutes les fonctions pour jouer au Nim.
 * @author Cedric et Paul-Aurian
 * @version 3.2 Human VS IA Naïve
 */
class Nim
{
	public static void main(String[] args)
	{
		HumanPlayer 	player;
		GameState 		currentGame;
		boolean 		bPlayAgain;
		boolean 		bIAWin;
		boolean 		bIAExist;
		Board 			table;
		IA 				ia;

		Console.script(0);//Greetings
		bIAExist = Console.askAnIA();
		ia = new IA();
		bIAWin = false;
		player = Console.getName((!bIAExist) ? 2 : 1);
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
					if (bIAExist && (table.getNbMatchLeft() > 1))
					{
						bIAWin = ia.iaPlays(table);
						currentGame.setNbMove();
					}
					else if (!bIAExist)
					{
						player = player.getNext();
						Console.clear_term();
					}
				}
				Console.printNbMatchLeft(table.getNbMatchLeft());
				if (bIAWin || ((table.getNbMatchLeft() < 1) && bIAExist))
				{
					bIAWin = true;
					Console.script(2);//Donne l'information que l'ia a gagné
					ia.setNbWins();
				}
			}
			if (!bIAWin)
			{
				if (!bIAExist && table.getNbMatchLeft() > 0)
					Console.showWinner(player.getNext().getName());
				else
					Console.showWinner(player.getName());
				player.setNbWins();
			}
			Console.nbMovePlayed(currentGame.getNbMove());
			currentGame.setState(false);
			bPlayAgain = Console.askToPlayAgain();
		}
		Console.printNbWins(player, (!bIAExist) ? (player.getNext().getNbWins()) : (ia.getNbWins()));
	}
}