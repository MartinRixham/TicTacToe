package tictactoe;

import java.io.PrintStream;
import java.util.Scanner;

public class Human implements Player
{
	private Scanner in;

	private PrintStream out;

	private String symbol;

	public Human(Scanner in, PrintStream out, String symbol)
	{
		this.in = in;
		this.out = out;
		this.symbol = symbol;
	}

	@Override
	public int getNextMove(Board board)
	{
		while (true)
		{
			prompt(board);

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

	@Override
	public String getSymbol()
	{
		return symbol;
	}

	private void prompt(Board board)
	{
		String availableSpots = board.getAvailableSpaces().toString();

		out.print("Pick one of the available spots ");
		out.print(availableSpots.substring(1, availableSpots.length() - 1));
		out.println(":");
	}
}
