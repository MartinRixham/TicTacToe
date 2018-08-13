package tictactoe;

public final class Game
{
	private String[] board = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
	private Player human = new Human();
	private Player computer = new Computer();

	public static void main(String[] args)
	{
		Game game = new Game();
		game.play();
	}

	public void play()
	{
		System.out.println(printBoard());
		do
		{
			int spot = human.getNextMove(board);
			board[spot] = "X";
			System.out.println(printBoard());
			if (!gameIsOver() && !tie())
			{
				spot = computer.getNextMove(board);
				board[spot] = "O";
				System.out.println(printBoard());
			}
		}
		while (!gameIsOver() && !tie()); // repeat if not game-over
		System.out.print("Game over\n");
	}

	/**
	 * Return true if the game was just won
	 */
	public boolean gameIsOver()
	{
		return board[0] == board[1] && board[1] == board[2] ||
			board[3] == board[4] && board[4] == board[5] ||
			board[6] == board[7] && board[7] == board[8] ||
			board[0] == board[3] && board[3] == board[6] ||
			board[1] == board[4] && board[4] == board[7] ||
			board[2] == board[5] && board[5] == board[8] ||
			board[0] == board[4] && board[4] == board[8] ||
			board[2] == board[4] && board[4] == board[6];
	}

	/**
	 * Return true if it is a draw (no more empty cell)
	 */
	// TODO: maybe there is an easeir way to check this
	public boolean tie()
	{
		return board[0] != "0" &&
			board[1] != "1" &&
			board[2] != "2" &&
			board[3] != "3" &&
			board[4] != "4" &&
			board[5] != "5" &&
			board[6] != "6" &&
			board[7] != "7" &&
			board[8] != "8";
	}

	/**
	 * Print the game board
	 */
	public String printBoard()
	{
		return " " + board[0] + " | " + board[1] + " | " + board[2] +
			"\n===+===+===\n" + " " + board[3] + " | " + board[4] + " | " + board[5] +
			"\n===+===+===\n" + " " + board[6] + " | " + board[7] + " | " + board[8] +
			"\n"; // print all the board cells
	}
}
