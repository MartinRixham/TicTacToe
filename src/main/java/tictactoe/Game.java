package tictactoe;

import java.io.PrintStream;
import java.util.Scanner;

public final class Game
{
	private PrintStream out;

	private Board board = new Board();

	private Player firstPlayer;

	private Player secondPlayer;

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		PrintStream out = System.out;
		PlayerSelection playerSelection = new ManualPlayerSelection(in, out);
		Game game = new Game(out, playerSelection);
		game.play();
	}

	public Game(PrintStream out, PlayerSelection playerSelection)
	{
		this.out = out;
		this.firstPlayer = playerSelection.getFirstPlayer();
		this.secondPlayer = playerSelection.getSecondPlayer();
	}

	public void play()
	{
		out.println(board);

		while (true)
		{
			int spot = firstPlayer.getNextMove(board);
			board.set(spot, firstPlayer.getSymbol());

			out.println("Player 1 picks spot: " + spot);
			out.println(board);

			if (board.gameIsOver())
			{
				out.println("Player 1 wins!");
				return;
			}

			if (board.isTied())
			{
				out.println("It's a tie!");
				return;
			}

			spot = secondPlayer.getNextMove(board);
			board.set(spot, secondPlayer.getSymbol());

			out.println("Player 2 picks spot: " + spot);
			out.println(board);

			if (board.gameIsOver())
			{
				out.println("Player 2 wins!");
				return;
			}

			if (board.isTied())
			{
				out.println("It's a tie!");
				return;
			}
		}
	}
}
