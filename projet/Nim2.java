import java.util.Scanner;
/**
 * Appelle une a une toutes les fonctions pour jouer au Nim.
 * @author Paul-Aurian
 * @version 3.1 Human VS Human
 */
class Nim2
{
	public static void main(String[] args) 
	{
	    GameState 		currentGame;
		HumanPlayer		Player1;
		Ia_intel Bot;
		Board			table;
		int				i;
		Scanner sc;
		int compt;
		int[] tab;
		boolean bwantToPlayAgain;
		boolean winsIa;
		boolean winsPlayer;
		boolean ends;
		int ask;

		bwantToPlayAgain = true;
		currentGame = new GameState();

		while(bwantToPlayAgain)
		{
		    sc = new Scanner(System.in);
		    
		    Console.script(0);
	    
		    ask = 0;
		    
		    Console.script(1);
		    table = new Board();

		    tab = table.getBoard();
		    Bot = new Ia_intel(tab);
		    Player1 = Console.getName1();
		    i = 0;
		    Console.clear_term();
		    ends = false;
		    winsIa = false;
		    winsPlayer = false;
		    while (table.getNbMatchLeft() > 1 || ends == false)
		    {
			Console.ShowBoard(table.getBoard());
			compt = 0;
			while(compt < 2)
			{
			    if(compt == 0)
			    {
				if (table.setBoard(Console.getMove(Bot.getName(), Bot.SmartChoice(table.getBoard(), table.getNbMatchLeft()))))
				    {
			  
					currentGame.setNbMove();
				    }
				System.out.println("Nombre d'allumettes restantes sur le plateau : " + table.getNbMatchLeft());
				compt++;

				if(table.getNbMatchLeft() == 0 && winsPlayer == false)
				{
				    winsPlayer = true;
				    compt = 3;
				}
				else  if(table.getNbMatchLeft() == 1 && winsPlayer == false)
				{
				    winsIa = true;
				    compt = 3;
				}
			    }
			    else if(compt == 1)
			    {
				Console.ShowBoard(table.getBoard());
				if (table.setBoard(Console.getMove(Player1.getName(), table.getBoard())))
				    {
					currentGame.setNbMove();
				    }
				Console.clear_term();
				System.out.println("Nombre d'allumettes restantes sur le plateau : " + table.getNbMatchLeft());
				compt++;

				if(table.getNbMatchLeft() == 0 && winsIa == false)
				    winsIa = true;
				else  if(table.getNbMatchLeft() == 1 && winsIa == false)
				    winsPlayer = true;
			    }

			    
			    
			}

			if(winsIa == true || winsPlayer == true)
			    ends = true;
			
		    }
		    if(winsIa)
		    {
			Console.showWinner(Bot.getName());
			Bot.setNbWin();
		    }
		    else if (winsPlayer)
		    {
			Console.showWinner(Player1.getName());
			Player1.setNbWins();
		    }

		    System.out.println("Voulez-vous rejouer la partie?");
		    ask = sc.nextInt();

		    if(ask == 1)
			bwantToPlayAgain = true;
		    else if(ask ==0)
			bwantToPlayAgain = false;
			    
		    
	        }
		currentGame.setState(false);
	}
}
