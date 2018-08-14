package tictactoe;

import java.io.PrintStream;
import java.util.Scanner;

public final class Game
{
	private PrintStream out;

	private Board board = new Board();

	private Player human;

	private Player computer = new Computer(board);

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		PrintStream out = System.out;
		Game game = new Game(in, out);
		game.play();
	}

	public Game(Scanner in, PrintStream out)
	{
		this.out = out;
		this.human = new Human(in, out, board);
	}

	public void play()
	{
		out.println(board);

		while (true)
		{
			int spot = human.getNextMove();
			board.set(spot, "X");

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

			spot = computer.getNextMove();
			board.set(spot, "O");

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
