class Board
{
	private GameState		status;
	private HumanPlayer		player1;
	private HumanPlayer		player2;

	public static void Board()
	{
		this.player1 = new HumanPlayer(sc.nextLine());
		this.player2 = new HumanPlayer(sc.nextLine());
	}

	public static void reset()
	{
		this.player1 = new HumanPlayer(sc.nextLine());
		this.player2 = new HumanPlayer(sc.nextLine());
	}
}