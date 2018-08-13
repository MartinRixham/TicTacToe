package tictactoe;

public final class Game
{
	private Board board = new Board();
	private Player human = new Human(System.in, System.out);
	private Player computer = new Computer();

	public static void main(String[] args)
	{
		Game game = new Game();
		game.play();
	}

	public void play()
	{
		System.out.println(board);
		do
		{
			int spot = human.getNextMove(board);
			board.set(spot, "X");
			System.out.println(board);
			if (!board.gameIsOver() && !board.isTied())
			{
				spot = computer.getNextMove(board);
				board.set(spot, "O");
				System.out.println(board);
			}
		}
		while (!board.gameIsOver() && !board.isTied()); // repeat if not game-over
		System.out.print("Game over\n");
	}
}
