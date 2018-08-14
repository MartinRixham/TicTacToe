package tictactoe;

import java.io.PrintStream;
import java.util.Scanner;

public class Human implements Player
{
	private Scanner in;

	private PrintStream out;

	private Board board;

	public Human(Scanner in, PrintStream out, Board board)
	{
		this.in = in;
		this.out = out;
		this.board = board;
	}

	@Override
	public int getNextMove()
	{
		while (true)
		{
			prompt();

			if (in.hasNextInt())
			{
				int spot = in.nextInt();
				if (board.isAvailable(spot))
				{
					return spot;
				}
			}
			else
			{
				in.nextLine();
			}
		}
	}

	private void prompt()
	{
		String availableSpots = board.getAvailableSpaces().toString();

		out.print("Pick one of the available spots ");
		out.print(availableSpots.substring(1, availableSpots.length() - 1));
		out.println(":");
	}
}
