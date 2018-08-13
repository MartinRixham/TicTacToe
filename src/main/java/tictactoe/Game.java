package tictactoe;

public final class Game
{
	private Board board = new Board();

	private Player human = new Human(System.in, System.out, board);

	private Player computer = new Computer(board);

	public static void main(String[] args)
	{
		Game game = new Game();
		game.play();
	}

	public void play()
	{
		System.out.println(board);

		while (true)
		{
			int spot = human.getNextMove();
			board.set(spot, "X");

			System.out.println("Player 1 picks spot: " + spot);
			System.out.println(board);

			if (board.gameIsOver())
			{
				System.out.println("Player 1 wins!");
				return;
			}

			if (board.isTied())
			{
				System.out.println("It's a tie!");
				return;
			}

			spot = computer.getNextMove();
			board.set(spot, "O");

			System.out.println("Player 2 picks spot: " + spot);
			System.out.println(board);

			if (board.gameIsOver())
			{
				System.out.println("Player 2 wins!");
				return;
			}

			if (board.isTied())
			{
				System.out.println("It's a tie!");
				return;
			}
		}
	}
}
